package com.cars24.template.controller;

import com.cars24.template.response.MessageResponseEntity;
import com.cars24.template.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/appointments")
@Slf4j
public class AppointmentController {


    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(value="/{idLmsAppointment}", method = RequestMethod.GET)
    public MessageResponseEntity getAppointment(@PathVariable(value = "idLmsAppointment") Long idLmsAppointment){
        log.info("request to get appointment with Id {} ", idLmsAppointment);
        try{
            return new MessageResponseEntity<>(appointmentService.getAppointment(idLmsAppointment));
        } catch (Exception e) {
            log.error("Error while getting app info");
            return new MessageResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "error");
        }
    }
}
