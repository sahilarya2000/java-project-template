package com.practice.template.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InspectionMakeDto {

    @JsonProperty("make_id")
    private Long makeId;

    @JsonProperty("make_name")
    private Long makeName;

    @JsonProperty("display_order")
    private Long displayOrder;

    @JsonProperty("status")
    private Long status;
}
