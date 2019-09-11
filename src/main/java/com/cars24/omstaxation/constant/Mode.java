package com.cars24.omstaxation.constant;

import com.cars24.omstaxation.exception.ValidationException;
import org.springframework.http.HttpStatus;

public enum Mode {
  INCLUSIVE,EXCLUSIVE;
  public static Mode getMode(String chargeMode){
    for (Mode mode:Mode.values()) {
      if (mode.name().equalsIgnoreCase(chargeMode)){
        return mode;
      }
    }
    throw new ValidationException(HttpStatus.BAD_REQUEST,"Invalid Mode");
  }
}
