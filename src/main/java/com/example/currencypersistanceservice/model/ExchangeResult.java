package com.example.currencypersistanceservice.model;

import lombok.Data;

@Data
public class ExchangeResult {
    private Query query;
    private double result;
    private boolean success;


}
