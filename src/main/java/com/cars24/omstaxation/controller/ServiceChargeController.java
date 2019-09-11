package com.cars24.omstaxation.controller;

import com.cars24.omstaxation.dto.ServiceChargeDto;
import com.cars24.omstaxation.dto.response.Response;
import com.cars24.omstaxation.entity.ServiceCharge;
import com.cars24.omstaxation.service.ServiceChargeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/service/charge")
@Slf4j
public class ServiceChargeController {


  @Autowired
  private ServiceChargeService serviceChargeService;

  @GetMapping("/get/{id}")
  public ResponseEntity<Response> get(@PathVariable Long id){
    log.info("service charge get api request : {}",id);
    Response response = serviceChargeService.get(id);
    log.info("service charge get api response : {}",response);
    return new ResponseEntity<>(response,HttpStatus.valueOf(response.getStatus()));
  }

  @PutMapping("/update")
  public ResponseEntity<Response> update(@Valid @RequestBody ServiceChargeDto serviceChargeDto){
    log.info("service charge add api called : {} ", serviceChargeDto);
    Response response = serviceChargeService.add(serviceChargeDto);
    log.info("service charge add api response  : {} ", response);
    return new ResponseEntity<>(response,HttpStatus.valueOf(response.getStatus()));
  }

  @PostMapping("/add")
  public ResponseEntity<Response> add(@Valid @RequestBody ServiceChargeDto serviceChargeDto){
    log.info("service charge add api called : {} ", serviceChargeDto);
    Response response = serviceChargeService.add(serviceChargeDto);
    log.info("service charge add api response  : {} ", response);
    return new ResponseEntity<>(response,HttpStatus.valueOf(response.getStatus()));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Response> delete(@PathVariable Long id){
    log.info("service charge delete api called id :  {} ", id);
    Response response = serviceChargeService.delete(id);
    log.info("service charge delete api response {} ", response);
    return new ResponseEntity<>(response,HttpStatus.valueOf(response.getStatus()));
  }


}
