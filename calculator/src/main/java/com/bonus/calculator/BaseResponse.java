package com.bonus.calculator;

import lombok.Builder;

import java.util.List;
import java.util.Map;

public class BaseResponse<T> {
    public static final int SUCCESS = 1;

    public static final int FAILED = 0;

    @Builder.Default
    private int statusCode = FAILED;

    private String errorMessage;

    private Map<String, List<T>> data;



    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, List<T>> getData() {
        return data;
    }

    public void setData(Map<String, List<T>> map) {
        this.data = map;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
