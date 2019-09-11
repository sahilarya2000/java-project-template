package com.cars24.omstaxation.service;

import com.cars24.omstaxation.dto.TaxConfigDto;
import com.cars24.omstaxation.dto.response.Response;
import com.cars24.omstaxation.exception.SystemException;
import com.cars24.omstaxation.exception.TaxConfigNotFoundException;

public interface TaxConfigService {
    Response getTaxConfig(Long stateId) throws TaxConfigNotFoundException;

    Response add(TaxConfigDto taxConfigDto, boolean isUpdate) throws SystemException;

    Response delete(long id) throws SystemException;
}
