package com.com.exception;

import java.io.Serializable;

public class ServiceException extends Exception implements Serializable {
    private String code = "";
    private String message = "";

    public ServiceException(String message) {
        this.message = message;
    }

    public ServiceException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
