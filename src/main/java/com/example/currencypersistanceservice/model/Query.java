package com.example.currencypersistanceservice.model;

import lombok.Data;

@Data
public class Query {

    private String from;
    private String to;
    private double amount;
}
