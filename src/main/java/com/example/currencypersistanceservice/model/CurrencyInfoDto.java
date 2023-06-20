package com.example.currencypersistanceservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Builder
public class CurrencyInfoDto {

    private String currency;
    private String code;
    private BigDecimal bid;
    private BigDecimal ask;

}
