package com.cars24.omstaxation.constant;

import com.cars24.omstaxation.exception.ValidationException;
import org.springframework.http.HttpStatus;

public enum AmountType {
  PERCENTAGE,FIX;

  public static AmountType get(String amountType) {
    for (AmountType amount:AmountType.values()) {
      if (amount.name().equalsIgnoreCase(amountType)){
        return amount;
      }
    }
    throw new ValidationException(HttpStatus.BAD_REQUEST,"Invalid AmountType");
  }
}
