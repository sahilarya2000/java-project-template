package com.cars24.omstaxation.service;

import com.cars24.omstaxation.dto.TaxConfigDto;
import com.cars24.omstaxation.exception.SystemException;

public interface TaxConfigService {
    TaxConfigDto getTaxConfig(String state) throws SystemException;
}
