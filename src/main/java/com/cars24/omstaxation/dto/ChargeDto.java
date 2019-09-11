package com.cars24.omstaxation.dto;

import com.cars24.omstaxation.validation.NotNull;
import com.cars24.omstaxation.validation.ValidateAmountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ChargeDto {
  private Long id;
  private Double rangeStart;
  private Double rangeEnd;
  @NotNull(message = "Amount Required")
  private Double amount;
  @ValidateAmountType(message = "Invalid AmountType")
  private String amountType;
}
