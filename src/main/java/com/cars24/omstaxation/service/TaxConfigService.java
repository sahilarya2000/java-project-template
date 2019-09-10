package com.cars24.omstaxation.service;

import com.cars24.omstaxation.entity.TaxConfig;
import com.cars24.omstaxation.exception.TaxConfigNotFoundException;

public interface TaxConfigService {
    TaxConfig getTaxConfig(String state) throws TaxConfigNotFoundException;
}
