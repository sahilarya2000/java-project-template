package com.cars24.omstaxation.exception;

import org.springframework.http.HttpStatus;

public class ValidationException extends RuntimeException {

  private HttpStatus status = HttpStatus.BAD_REQUEST;

  public ValidationException() {
  }

  public ValidationException(HttpStatus status, String message) {
    super(message);
    this.status = status;
  }

  public ValidationException(String message) {
    super(message);
  }

  public HttpStatus getStatus() {
    return status;
  }
}
