package com.intratracker.backend.exception;

import org.springframework.http.HttpStatus;

public class RestErrorMessage {
    private String message;
    private String details;
    private HttpStatus status;

    public RestErrorMessage(String message, HttpStatus status, String details) {
        this.message = message;
        this.status = status;
        this.details = details;
    }

    public RestErrorMessage() {
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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
