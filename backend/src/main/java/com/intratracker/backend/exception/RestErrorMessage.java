package com.intratracker.backend.exception;

import org.springframework.http.HttpStatus;

public class RestErrorMessage {
    private String message;
    private HttpStatus status;

    public RestErrorMessage(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public RestErrorMessage() {
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
