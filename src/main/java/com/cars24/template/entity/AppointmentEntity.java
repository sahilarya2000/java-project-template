package com.cars24.template.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Getter
@Setter
@ToString
@Entity
@Table(name = "lms_appointment")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lms_appointment")
    private long idLmsAppointment;

    @Column(name = "appointment")
    private String appointment;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "variant")
    private String variant;

    @Column(name = "year")
    private String year;

}
