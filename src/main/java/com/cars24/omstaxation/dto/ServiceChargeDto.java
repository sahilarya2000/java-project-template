package com.cars24.omstaxation.dto;

import com.cars24.omstaxation.constant.Mode;
import com.cars24.omstaxation.constant.Type;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class ServiceChargeDto {

  private Long id;
  @NotNull(message = "Name Required")
  private String name;
  @NotNull(message = "ServiceCharge Key Required")
  private String chargeKey;
  @NotNull(message = "Mode Required")
  private Mode chargeMode;
  @NotNull(message = "charges Required")
  private List<ChargeDto> charges;
  @NotNull(message = "ChargeType Required")
  private Type ChargeType;

}
