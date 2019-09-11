package com.cars24.omstaxation.service.impl;

import com.cars24.omstaxation.dto.TaxConfigDto;
import com.cars24.omstaxation.dto.response.Response;
import com.cars24.omstaxation.dto.response.ResponseBuilderUtil;
import com.cars24.omstaxation.entity.TaxConfig;
import com.cars24.omstaxation.exception.SystemException;
import com.cars24.omstaxation.exception.TaxConfigNotFoundException;
import com.cars24.omstaxation.repository.TaxConfigRepository;
import com.cars24.omstaxation.service.TaxConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author sauniksingh
 */
@Slf4j
@Service
public class TaxConfigServiceImpl implements TaxConfigService {
    @Autowired
    private TaxConfigRepository taxConfigRepository;

    @Override
    public Response getTaxConfig(String state) throws TaxConfigNotFoundException {
        Optional<TaxConfig> taxConfig = taxConfigRepository.findByState(state);
        if (!taxConfig.isPresent()) {
            throw new TaxConfigNotFoundException(HttpStatus.NOT_FOUND.value(), state, "Tax details are not available for the state " + state);
        }
        TaxConfigDto taxConfigDto = new TaxConfigDto();
        BeanUtils.copyProperties(taxConfig.get(), taxConfigDto);
        return ResponseBuilderUtil.successResponseWithData(HttpStatus.OK.value(), "Tax Details Fetched Successfully.", taxConfigDto);
    }

    @Override
    public Response add(TaxConfigDto taxConfigDto, boolean isUpdate) throws SystemException {
        if (taxConfigDto == null) {
            throw new SystemException(HttpStatus.BAD_REQUEST.value(), "Tax Details can't be save");
        }
        if (taxConfigDto.getId() <= 0 && isUpdate) {
            throw new SystemException(HttpStatus.BAD_REQUEST.value(), "Tax Details can't be update, Id required");
        }
        TaxConfig taxConfig = new TaxConfig();
        BeanUtils.copyProperties(taxConfigDto, taxConfig);
        taxConfig = taxConfigRepository.save(taxConfig);
        log.info("Tax Details saved {} ", taxConfig);
        return ResponseBuilderUtil.successResponse(HttpStatus.OK.value(), "Tax Details Saved/Updated Successfully.");
    }

    @Override
    public Response delete(long id) throws SystemException {
        Optional<TaxConfig> taxConfig = taxConfigRepository.findById(id);
        if (!taxConfig.isPresent()) {
            throw new SystemException(HttpStatus.NOT_FOUND.value(), "Tax details are not available for the id " + id);
        }
        taxConfigRepository.delete(taxConfig.get());
        return ResponseBuilderUtil.successResponse(HttpStatus.OK.value(), "Tax details Deleted Successfully.");

    }
}
