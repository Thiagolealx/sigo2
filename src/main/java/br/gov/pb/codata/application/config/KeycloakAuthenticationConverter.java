package br.gov.pb.codata.application.config;

import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class KeycloakAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private static final String USERNAME_CLAIM = "preferred_username";

    private final JwtAuthenticationConverter jwtAuthConverter = new JwtAuthenticationConverter();

    private final String clientId;

    @Override
    public AbstractAuthenticationToken convert(@NonNull Jwt jwt) {
        var authorities = new ArrayList<>(jwtAuthConverter.convert(jwt).getAuthorities());
        authorities.addAll(this.getRoles(jwt));

        var username = jwt.getClaimAsString(USERNAME_CLAIM);
        return new JwtAuthenticationToken(jwt, Collections.unmodifiableCollection(authorities), username);
    }

    private List<GrantedAuthority> getRoles(Jwt jwt) {
        var resourceAccess = (JSONObject) jwt.getClaims().getOrDefault("resource_access", new JSONObject());
        var client = (JSONObject) resourceAccess.getOrDefault(clientId, new JSONObject());

        return ((JSONArray)client.getOrDefault("roles", new JSONArray()))
                .stream()
                .map(role -> ((String) role).toUpperCase().replace(".", "_"))
                .map(role -> (GrantedAuthority) new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }
}

