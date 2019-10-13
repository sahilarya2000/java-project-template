package com.cars24.template.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MakeListResponseDto {

    @JsonProperty("type")
    private String type;

    @JsonProperty("title")
    private String title;

    @JsonProperty("status")
    private String status;

    @JsonProperty("timestamp")
    private Long timestamp;

    @JsonProperty("detail")
    private List<InspectionMakeDto> detail;
}
