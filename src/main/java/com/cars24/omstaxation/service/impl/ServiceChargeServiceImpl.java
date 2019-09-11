package com.cars24.omstaxation.service.impl;

import com.cars24.omstaxation.constant.AmountType;
import com.cars24.omstaxation.constant.Mode;
import com.cars24.omstaxation.constant.Type;
import com.cars24.omstaxation.dto.ChargeDto;
import com.cars24.omstaxation.dto.ServiceChargeDto;
import com.cars24.omstaxation.dto.response.Response;
import com.cars24.omstaxation.dto.response.ResponseBuilderUtil;
import com.cars24.omstaxation.entity.Charge;
import com.cars24.omstaxation.entity.ServiceCharge;
import com.cars24.omstaxation.exception.ValidationException;
import com.cars24.omstaxation.repository.ServiceChargeRepository;
import com.cars24.omstaxation.service.ChargeService;
import com.cars24.omstaxation.service.ServiceChargeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ServiceChargeServiceImpl implements ServiceChargeService {

  @Autowired
  private ServiceChargeRepository serviceChargeRepository;

  @Autowired
  private ChargeService chargeService;

  @Override
  public Response add(ServiceChargeDto serviceChargeDto) {
    Response response;
    validate(serviceChargeDto);
    try {
      ServiceCharge serviceCharge = fetchServiceCharge(serviceChargeDto.getId());
      BeanUtils.copyProperties(serviceChargeDto, serviceCharge, "charges");
      serviceCharge.setChargeType(Type.getType(serviceChargeDto.getChargeType()));
      serviceCharge.setChargeMode(Mode.getMode(serviceChargeDto.getChargeMode()));

      List<Charge> chargeList = chargeService.getChargeList(serviceChargeDto.getCharges(), serviceCharge.getCharges());

      serviceCharge.setCharges(chargeList);
      serviceCharge = serviceChargeRepository.save(serviceCharge);

      log.info("service charge saved {} ", serviceCharge);
      response = ResponseBuilderUtil.successResponse(HttpStatus.OK.value(), "Service Charge Saved/Updated Successfully.");

    } catch (Exception exception) {
      log.info("error in adding or updating service charge | {} ", exception);
      response = ResponseBuilderUtil.errorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error in saving/updation Service Charges");
    }

    return response;
  }

  private void validate(ServiceChargeDto serviceChargeDto) {
    List<ChargeDto> chargeDtoList = serviceChargeDto.getCharges();

    if (chargeDtoList == null || chargeDtoList.size() <= 0) {
      throw new ValidationException(HttpStatus.BAD_REQUEST, "Charges Required");
    }

    Type chargeType = Type.getType(serviceChargeDto.getChargeType());

    if (chargeType == Type.FLAT && chargeDtoList.size() > 1) {
      throw new ValidationException(HttpStatus.BAD_REQUEST, "More Than One Charge Found For Flat ChargeType");
    }

    for (ChargeDto chargeDto : chargeDtoList) {
      if (AmountType.FIX == AmountType.get(chargeDto.getAmountType()) && chargeDto.getAmount() < 0) {
        log.info("Invalid Amount {}", chargeDto.getAmount());
        throw new ValidationException(HttpStatus.BAD_REQUEST, "Invalid Amount");
      }
      if (AmountType.PERCENTAGE == AmountType.get(chargeDto.getAmountType()) &&
          (chargeDto.getAmount() < 0 || chargeDto.getAmount() > 100)) {
        log.info("Amount should be 0 - 100 | {} ", chargeDto.getAmount());
        throw new ValidationException(HttpStatus.BAD_REQUEST, "Amount should be 0 - 100 ");
      }

      if (chargeType == Type.SLAB && (chargeDto.getRangeStart() < 0 || chargeDto.getRangeStart() < 0 ||
          chargeDto.getRangeStart().equals(chargeDto.getRangeEnd()))) {
        log.info("Invalid Range start {} | End {} ", chargeDto.getRangeStart(), chargeDto.getRangeEnd());
        throw new ValidationException(HttpStatus.BAD_REQUEST, "Invalid Range");
      }

    }
  }

  private ServiceCharge fetchServiceCharge(Long id) {
    ServiceCharge serviceCharge = new ServiceCharge();
    Optional<ServiceCharge> serviceChargeOptional = serviceChargeRepository.findById(id);
    if (serviceChargeOptional.isPresent()) {
      serviceCharge = serviceChargeOptional.get();
    }
    return serviceCharge;
  }

  @Override
  public Response delete(Long id) {
    Response response;
    Optional<ServiceCharge> serviceCharge = serviceChargeRepository.findById(id);
    if (serviceCharge.isPresent()) {
      try {
        serviceChargeRepository.delete(serviceCharge.get());
        response = ResponseBuilderUtil.successResponse(HttpStatus.OK.value(), "Service Charge Deleted Successfully.");
      } catch (Exception exception) {
        log.info("Error in deleting service charge with id {} ", id);
        response = ResponseBuilderUtil.errorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error in Deleting Service Charges");
      }
    } else {
      response = ResponseBuilderUtil.errorResponse(HttpStatus.BAD_REQUEST.value(), "No Service Charge Available On Id " + id);

    }
    return response;
  }

  @Override
  public Response get(Long id) {
    Response response;
    Optional<ServiceCharge> serviceCharge = serviceChargeRepository.findById(id);
    if (serviceCharge.isPresent()) {
      try {
        ServiceCharge serviceCharges = serviceCharge.get();
        ServiceChargeDto serviceChargeDto = new ServiceChargeDto();
        BeanUtils.copyProperties(serviceCharges, serviceChargeDto);
        List<ChargeDto> chargeDtoList = chargeService.getChargeDtoList(serviceCharges.getCharges());
        serviceChargeDto.setCharges(chargeDtoList);
        response = ResponseBuilderUtil.successResponseWithData(HttpStatus.OK.value(), "Service Charge Fetched Successfully.", serviceChargeDto);
      } catch (Exception exception) {
        log.info("Error in deleting service charge with id {} ", id);
        response = ResponseBuilderUtil.errorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error in Fetching Service Charges");
      }
    } else {
      response = ResponseBuilderUtil.errorResponse(HttpStatus.BAD_REQUEST.value(), "No Service Charge Available on Id " + id);

    }
    return response;
  }

}
