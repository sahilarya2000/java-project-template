package com.cars24.omstaxation.service;

import com.cars24.omstaxation.dto.ServiceChargeDto;
import com.cars24.omstaxation.dto.response.Response;

public interface ServiceChargeService {

  Response add(ServiceChargeDto serviceChargeDto);

  Response delete(Long id);

  Response get(Long id);
}
