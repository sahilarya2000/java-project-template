package com.cars24.omstaxation.service;

import com.cars24.omstaxation.dto.TaxConfigDto;
import com.cars24.omstaxation.exception.TaxConfigNotFoundException;

public interface TaxConfigService {
    TaxConfigDto getTaxConfig(String state) throws TaxConfigNotFoundException;
}
