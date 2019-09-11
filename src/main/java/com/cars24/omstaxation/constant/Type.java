package com.cars24.omstaxation.constant;

import com.cars24.omstaxation.exception.ValidationException;
import org.springframework.http.HttpStatus;

public enum Type {
  FLAT,SLAB;

  public static Type getType(String chargeType){
    for (Type type:Type.values()) {
      if (type.name().equalsIgnoreCase(chargeType)){
        return type;
      }
    }
    throw new ValidationException(HttpStatus.BAD_REQUEST,"Invalid ChargeType");
  }
}
