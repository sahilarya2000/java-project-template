package com.cars24.omstaxation.dto;

import com.cars24.omstaxation.constant.AmountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class ChargeDto {
  private Long id;
  private Double rangeStart;
  private Double rangeEnd;
  @NotNull(message = "Amount Required")
  private Double amount;
  @NotNull(message = "Amount Type Required")
  private AmountType amountType;
}
