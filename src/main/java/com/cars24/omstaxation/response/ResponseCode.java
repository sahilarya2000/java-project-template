package com.cars24.omstaxation.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
/**@author Saunik Singh*/
@AllArgsConstructor
@Getter
public enum ResponseCode {
    TAXCONFIGINFO200("TAXCONFIG200", "Tax information returned successfully.", HttpStatus.ACCEPTED);
    private String code;
    private String message;
    private HttpStatus httpStatus;

}
