package com.example.currencypersistanceservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Entity
public class CurrencyInfo {

    @Id
    private String code;
    private String currency;
    private BigDecimal bid;
    private BigDecimal ask;
}
