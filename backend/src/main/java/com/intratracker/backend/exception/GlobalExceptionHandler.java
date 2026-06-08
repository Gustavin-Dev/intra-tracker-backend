package com.intratracker.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<RestErrorMessage> HandleResourceNotFoundException(ResourceNotFoundException exception) {

        RestErrorMessage treatedResponse = new RestErrorMessage(
                exception.getMessage(),
                HttpStatus.NOT_FOUND);

        return ResponseEntity.status(treatedResponse.getStatus()).body(treatedResponse);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<RestErrorMessage> genericException(
            Exception exception) {

        RestErrorMessage treatedResponse = new RestErrorMessage(
                "Internal server error.",
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage()
        );

        return ResponseEntity
                .status(treatedResponse.getStatus())
                .body(treatedResponse);
    }
}
