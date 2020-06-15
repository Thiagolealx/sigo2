package br.gov.pb.codata.application.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HttpException extends RuntimeException {
    private final HttpStatus code;

    public HttpException(HttpStatus code) {
        super();
        this.code = code;
    }

    public HttpException(HttpStatus code, String message) {
        super(message);
        this.code = code;
    }
}
