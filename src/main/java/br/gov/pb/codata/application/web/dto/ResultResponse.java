package br.gov.pb.codata.application.web.dto;

import lombok.Getter;

@Getter
public class ResultResponse<T> {
    private T result = null;
    private String error = null;

    private ResultResponse() {}

    public ResultResponse(T result) {
        this.result = result;
    }

    public static ResultResponse<Void> error(String error) {
        var response = new ResultResponse<Void>();
        response.error = error;
        return response;
    }
}
