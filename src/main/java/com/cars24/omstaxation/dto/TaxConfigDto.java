package com.cars24.omstaxation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author sauniksingh
 * Date: 10/09/19
 */
@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.ALWAYS)
@ToString
public class TaxConfigDto {
    private Double sgst;
    private Double cgst;
    private Double cess;
    private String state;
}
