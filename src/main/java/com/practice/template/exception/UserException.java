package com.practice.template.exception;

import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException {

    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public UserException() {
    }

    public UserException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public UserException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return status;
    }
}
