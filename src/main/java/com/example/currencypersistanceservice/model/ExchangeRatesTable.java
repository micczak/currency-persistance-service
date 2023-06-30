package com.example.currencypersistanceservice.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Currency;

@Data
public class ExchangeRatesTable {
    @NotBlank
    private String table;

    @NotBlank
    private String no;

    @NotNull
    private LocalDate tradingDate;

    @NotNull
    private LocalDate effectiveDate;

    @Valid
    private CurrencyInfo currencies;
}

