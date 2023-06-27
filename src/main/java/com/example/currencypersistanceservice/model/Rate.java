package com.example.currencypersistanceservice.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Rate {
    @NotBlank
    private String currency;

    @NotBlank
    private String code;

    @NotNull
    private Double bid;

    @NotNull
    private Double ask;
}
