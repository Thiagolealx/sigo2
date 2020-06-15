package br.gov.pb.codata.application.web.exceptionHandler;

import br.gov.pb.codata.application.exception.HttpException;
import br.gov.pb.codata.application.exception.NotFoundException;
import br.gov.pb.codata.application.service.MessagesFacade;
import br.gov.pb.codata.application.web.dto.ResultResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "br.gov.pb.codata.application.web.controller")
@Slf4j
@RequiredArgsConstructor
public class DefaultExceptionHandler {

    private final MessagesFacade messages;

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException e) {
        String message;
        if (e.getMessage() != null) {
            message = e.getMessage();
        } else {
            message = messages.getMessage("error.notFound");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResultResponse.error(message));
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<?> handleHttpException(HttpException e) {
        var code = e.getCode();
        var message = e.getMessage();
        if (message == null) {
            message = messages.getMessage("error.generic");
        }
        return ResponseEntity.status(code).body(ResultResponse.error(message));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        log.error("Application Error", e);
        var message = e.getMessage();
        if (message == null) {
            message = messages.getMessage("error.generic");
        }
        return ResponseEntity.status(500).body(ResultResponse.error(message));
    }
}
