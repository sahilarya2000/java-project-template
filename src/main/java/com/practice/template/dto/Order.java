package com.practice.template.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Order {

    @JsonProperty("order_id")
    private String orderId;


}
