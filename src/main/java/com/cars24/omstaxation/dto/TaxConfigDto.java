package com.cars24.omstaxation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author sauniksingh
 * Date: 10/09/19
 */
@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.ALWAYS)
@ToString
public class TaxConfigDto {
    @NotNull(message = "SGST can't be null")
    private Double sgst;
    @NotNull(message = "CGST can't be null")
    private Double cgst;
    @NotNull(message = "Cess can't be null")
    private Double cess;
    @NotNull(message = "State Required")
    private String state;
    private long id;
}
