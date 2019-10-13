package com.cars24.template.service.impl;

import com.cars24.template.dto.AppointmentDto;
import com.cars24.template.entity.AppointmentEntity;
import com.cars24.template.repository.AppointmentRepository;
import com.cars24.template.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

@Service
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public AppointmentEntity save(AppointmentDto appointmentDto) {
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setAppointment(appointmentDto.getAppointment());
        appointmentEntity.setMake(appointmentDto.getMake());
        return appointmentRepository.save(appointmentEntity);
    }

    @Override
    public AppointmentDto getAppointment(Long idLmsAppointment) {
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        Optional<AppointmentEntity> appointmentEntityOptional = appointmentRepository.findById(idLmsAppointment);
        if (appointmentEntityOptional.isPresent())
            appointmentEntity = appointmentEntityOptional.get();
        return mapEntityToDto(appointmentEntity);
    }

    private AppointmentDto mapEntityToDto(AppointmentEntity appointmentEntity) {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setAppointment(appointmentEntity.getAppointment());
        appointmentDto.setMake(appointmentEntity.getMake());
        String s1 = this.getMakeList();
        appointmentDto.setResponse(s1);
        return appointmentDto;
    }

    private String getMakeList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> httpEntity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://insapi-qa31.ninja24.in/make", HttpMethod.GET, httpEntity, String.class).getBody();

    }
}
