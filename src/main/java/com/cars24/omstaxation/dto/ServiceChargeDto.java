package com.cars24.omstaxation.dto;

import com.cars24.omstaxation.constant.Mode;
import com.cars24.omstaxation.validation.NotNull;
import com.cars24.omstaxation.validation.ValidateMode;
import com.cars24.omstaxation.validation.ValidateType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ServiceChargeDto {

  private Long id;
  @NotNull(message = "Name Required")
  private String name;
  @NotNull(message = "ServiceChargeKey Required")
  private String chargeKey;
  @ValidateMode(message = "Invalid Mode")
  private String chargeMode;
  private List<ChargeDto> charges;
  @ValidateType(message = "Invalid ChargeType")
  private String ChargeType;

}
