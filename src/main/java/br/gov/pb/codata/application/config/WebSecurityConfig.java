package br.gov.pb.codata.application.config;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final List<String> ALLOW_ALL = Collections.singletonList("*");
    private static final List<String> EXPOSED_HEADERS = Collections.emptyList();

    @Value("${application.oidc.client-id}")
    private String clientId;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(new KeycloakAuthenticationConverter(clientId));
    }

    @Bean
    protected CorsConfigurationSource corsConfigurationSource() {

        final var config = new CorsConfiguration();
        config.setAllowedOrigins(ALLOW_ALL);
        config.setAllowedMethods(ALLOW_ALL);
        config.setAllowedHeaders(ALLOW_ALL);
        config.setExposedHeaders(EXPOSED_HEADERS);
        config.setAllowCredentials(true);

        final var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

}
