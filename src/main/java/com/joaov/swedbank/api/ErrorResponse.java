package com.joaov.swedbank.api;

public class ErrorResponse <T> extends CommonResponse <T>{
    public ErrorResponse(String error) {
        success = false;
        super.error = error;
    }
}
