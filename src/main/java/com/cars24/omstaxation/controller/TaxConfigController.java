package com.cars24.omstaxation.controller;

import com.cars24.omstaxation.dto.TaxConfigDto;
import com.cars24.omstaxation.dto.response.Response;
import com.cars24.omstaxation.exception.TaxConfigNotFoundException;
import com.cars24.omstaxation.service.TaxConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Saunik Singh
 */
@RequestMapping(value = "/taxConfig/")
@RestController
@Slf4j
public class TaxConfigController {

    @Autowired
    private TaxConfigService taxConfigService;

    @GetMapping(value = "get/{stateId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> get(@PathVariable Long stateId) throws TaxConfigNotFoundException {
        log.info("TaxConfig get {}", stateId);
        Response response = taxConfigService.getTaxConfig(stateId);
        log.info("TaxConfig get response for state: {}, response: {}", stateId, response);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @PutMapping("update")
    public ResponseEntity<Response> update(@Valid @RequestBody TaxConfigDto taxConfigDto) {
        log.info("TaxConfig update : {} ", taxConfigDto);
        Response response = taxConfigService.add(taxConfigDto, true);
        log.info("TaxConfig update api response  : {} ", response);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @PostMapping("add")
    public ResponseEntity<Response> add(@Valid @RequestBody TaxConfigDto taxConfigDto) {
        log.info("TaxConfig add : {} ", taxConfigDto);
        Response response = taxConfigService.add(taxConfigDto, false);
        log.info("TaxConfig add api response  : {} ", response);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id){
        log.info("TaxConfig delete api called id :  {} ", id);
        Response response = taxConfigService.delete(id);
        log.info("TaxConfig delete api response {} ", response);
        return new ResponseEntity<>(response,HttpStatus.valueOf(response.getStatus()));
    }
}
