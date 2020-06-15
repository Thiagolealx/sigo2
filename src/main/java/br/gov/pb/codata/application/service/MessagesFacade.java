package br.gov.pb.codata.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessagesFacade {

    private final MessageSource messages;

    public String getMessage(String messageId, Object... params) {
        return messages.getMessage(messageId, params, LocaleContextHolder.getLocale());
    }
}
