package com.cars24.omstaxation.service.impl;

import com.cars24.omstaxation.entity.TaxConfig;
import com.cars24.omstaxation.exception.TaxConfigNotFoundException;
import com.cars24.omstaxation.repository.TaxConfigRepository;
import com.cars24.omstaxation.service.TaxConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 * @author sauniksingh
 */
public class TaxConfigServiceImpl implements TaxConfigService {
    @Autowired
    private TaxConfigRepository taxConfigRepository;

    @Override
    public TaxConfig getTaxConfig(String state) throws TaxConfigNotFoundException {
        TaxConfig taxConfig = taxConfigRepository.findByState(state);
        if (taxConfig == null) {
            throw new TaxConfigNotFoundException(HttpStatus.BAD_REQUEST.value(), state, "Tax details not available");
        }
        return taxConfig;
    }
}
