package com.cars24.omstaxation.controller;

import com.cars24.omstaxation.dto.TaxConfigDto;
import com.cars24.omstaxation.exception.SystemException;
import com.cars24.omstaxation.response.CoreResponse;
import com.cars24.omstaxation.response.ResponseCode;
import com.cars24.omstaxation.service.TaxConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Saunik Singh
 */
@RequestMapping(value = "/taxConfig/")
@RestController
@Slf4j
public class TaxConfigController extends BaseController {

    @Autowired
    private TaxConfigService taxConfigService;

    @GetMapping(value = "getTax/{state}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoreResponse<TaxConfigDto>> getTaxConfig(@PathVariable String state) throws SystemException {
        log.info("[getTaxConfig] {}", createGetRequestInfo());
        TaxConfigDto taxConfig = taxConfigService.getTaxConfig(state);
        log.info("[getTaxConfig] taxConfig response for state: {}, response: {}", state, toJson(taxConfig));
        return CoreResponse.buildWithSuccess(ResponseCode.TAXCONFIGINFO200, taxConfig);
    }
}
