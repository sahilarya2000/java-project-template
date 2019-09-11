package com.cars24.omstaxation.service;

import com.cars24.omstaxation.dto.ChargeDto;
import com.cars24.omstaxation.entity.Charge;

import java.util.List;

public interface ChargeService {
  List<Charge> saveAll(List<Charge> chargeList);
  List<Charge> getChargeList(List<ChargeDto> charges, List<Charge> serviceChargeCharges);

  List<ChargeDto> getChargeDtoList(List<Charge> charges);
}
