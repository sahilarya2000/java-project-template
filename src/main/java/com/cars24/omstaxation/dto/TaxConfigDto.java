package com.cars24.omstaxation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author sauniksingh
 * Date: 10/09/19
 */
@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.ALWAYS)
@ToString
public class TaxConfigDto {
    @Min(value = 0, message = "SGST shouldn't be empty")
    private Double sgst;
    @Min(value = 0, message = "CGST shouldn't be empty")
    private Double cgst;
    @Min(value = 0, message = "CESS shouldn't be empty")
    private Double cess;
    @NotBlank(message = "State Required")
    private String state;
    private long id;
}
