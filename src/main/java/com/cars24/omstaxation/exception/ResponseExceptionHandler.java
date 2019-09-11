package com.cars24.omstaxation.exception;

import com.cars24.omstaxation.dto.response.Response;
import com.cars24.omstaxation.dto.response.ResponseBuilderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({ Exception.class })
  public ResponseEntity<Response> handleException(Exception e, HttpServletResponse httpServletResponse) {
    log.error("Exception error received - {} - {}", e, httpServletResponse);
    Response response = ResponseBuilderUtil.errorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
    log.error("Error data created from Exception handler- {}", response);
    return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
  }

  @ExceptionHandler({ValidationException.class})
  public ResponseEntity<Response> handler(ValidationException e, HttpServletResponse httpServletResponse) {
    log.error("Generic Exception error received - {} - {}", e, httpServletResponse);
    Response response = ResponseBuilderUtil.errorResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage());
    log.error("Error data created from Exception handler- {}", response);
    return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
  }
}
