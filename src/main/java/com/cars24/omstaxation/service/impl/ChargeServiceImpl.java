package com.cars24.omstaxation.service.impl;

import com.cars24.omstaxation.dto.ChargeDto;
import com.cars24.omstaxation.entity.Charge;
import com.cars24.omstaxation.repository.ChargeRepository;
import com.cars24.omstaxation.service.ChargeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChargeServiceImpl implements ChargeService {

  @Autowired
  private ChargeRepository chargeRepository;

  @Override
  public List<Charge> saveAll(List<Charge> chargeList) {
     return chargeRepository.saveAll(chargeList);
  }


  @Override
  public List<Charge> getChargeList(List<ChargeDto> charges) {
    List<Charge> chargeList = new ArrayList<>();
    for (ChargeDto chargeDto : charges) {
      Charge charge = new Charge();
      BeanUtils.copyProperties(chargeDto, charge);
      chargeList.add(charge);
    }
    return chargeList;
  }

  @Override
  public List<ChargeDto> getChargeDtoList(List<Charge> charges) {
    List<ChargeDto> chargeList = new ArrayList<>();
    for (Charge charge : charges) {
      ChargeDto chargeDto = new ChargeDto();
      BeanUtils.copyProperties(charge, chargeDto);
      chargeList.add(chargeDto);
    }
    return chargeList;
  }

}
