package com.cars24.omstaxation.service.impl;

import com.cars24.omstaxation.dto.TaxConfigDto;
import com.cars24.omstaxation.entity.TaxConfig;
import com.cars24.omstaxation.exception.TaxConfigNotFoundException;
import com.cars24.omstaxation.repository.TaxConfigRepository;
import com.cars24.omstaxation.service.TaxConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author sauniksingh
 */
@Slf4j
@Service
public class TaxConfigServiceImpl implements TaxConfigService {
    @Autowired
    private TaxConfigRepository taxConfigRepository;

    @Override
    public TaxConfigDto getTaxConfig(String state) throws TaxConfigNotFoundException {
        TaxConfig taxConfig = taxConfigRepository.findByState(state);
        if (taxConfig == null) {
            throw new TaxConfigNotFoundException(HttpStatus.BAD_REQUEST.value(), state, "Tax details not available");
        }
        TaxConfigDto taxConfigDto = new TaxConfigDto();
        BeanUtils.copyProperties(taxConfig, taxConfigDto);
        return taxConfigDto;
    }
}
