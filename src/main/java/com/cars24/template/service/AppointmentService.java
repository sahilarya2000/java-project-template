package com.cars24.template.service;

import com.cars24.template.dto.AppointmentDto;
import com.cars24.template.dto.UserDto;
import com.cars24.template.entity.AppointmentEntity;
import com.cars24.template.entity.UserEntity;

public interface AppointmentService {

    AppointmentDto getAppointment(Long idLmsAppointment);

    AppointmentEntity save(AppointmentDto appointmentDto);

}
