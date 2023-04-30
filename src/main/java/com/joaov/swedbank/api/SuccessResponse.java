package com.joaov.swedbank.api;

public class SuccessResponse <T> extends CommonResponse <T>{
    public SuccessResponse(T body) {
        response = body;
        success = true;
    }
}
