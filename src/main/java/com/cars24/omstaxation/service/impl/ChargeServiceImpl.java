package com.cars24.omstaxation.service.impl;

import com.cars24.omstaxation.constant.AmountType;
import com.cars24.omstaxation.dto.ChargeDto;
import com.cars24.omstaxation.entity.Charge;
import com.cars24.omstaxation.repository.ChargeRepository;
import com.cars24.omstaxation.service.ChargeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChargeServiceImpl implements ChargeService {

  @Autowired
  private ChargeRepository chargeRepository;

  @Override
  public List<Charge> saveAll(List<Charge> chargeList) {
     return chargeRepository.saveAll(chargeList);
  }


  @Override
  public List<Charge> getChargeList(List<ChargeDto> charges, List<Charge> serviceChargeCharges) {
    List<Charge> chargeList = serviceChargeCharges!=null ? serviceChargeCharges :  new ArrayList<>();
    chargeList.clear();
    for (ChargeDto chargeDto : charges) {
      Charge charge = fetchChargeObject(chargeDto.getId());
      BeanUtils.copyProperties(chargeDto, charge);
      charge.setAmountType(AmountType.get(chargeDto.getAmountType()));
      chargeList.add(charge);
    }
    return chargeList;
  }

  private Charge fetchChargeObject(Long id) {
    Charge charge = new Charge();
    Optional<Charge> chargeOptional = chargeRepository.findById(id);
    if (chargeOptional.isPresent()){
      charge = chargeOptional.get();
    }
    return charge;
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
