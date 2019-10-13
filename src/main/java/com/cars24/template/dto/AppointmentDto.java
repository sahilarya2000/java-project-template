package com.cars24.template.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AppointmentDto {

    @JsonProperty("appointment")
    private String appointment;

    @JsonProperty("make")
    private String make;

    @JsonProperty("model")
    private String model;

    @JsonProperty("variant")
    private String variant;

    @JsonProperty("year")
    private String year;

    @JsonProperty("makeList")
    private List<InspectionMakeDto> makeList;

    @JsonProperty("response")
    private  String response;


}
