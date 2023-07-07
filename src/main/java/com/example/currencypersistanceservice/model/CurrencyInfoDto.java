package com.example.currencypersistanceservice.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
public class CurrencyInfoDto {

    private String currency;
    private String code;
    private BigDecimal bid;
    private BigDecimal ask;
    // TODO: 07.07.2023  dodać baze danych, zrobić zxapisywanie, zobaczyć czy stare dane są nadpisywane przez nowe
}
