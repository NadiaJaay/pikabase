package com.nadiajaay.pika_base.dto;

import java.util.List;

public class ValidationErrorResponse {
    private int status;
    private List<String> errors;

    public ValidationErrorResponse(int status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public int getStatus() {
        return this.status;
    }

    public List<String> getErrors() {
        return this.errors;
    }

}
