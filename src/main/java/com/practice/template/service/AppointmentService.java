package com.practice.template.service;

import com.practice.template.dto.AppointmentDto;
import com.practice.template.entity.AppointmentEntity;

public interface AppointmentService {

    AppointmentDto getAppointment(Long idLmsAppointment);

    AppointmentEntity save(AppointmentDto appointmentDto);

}
