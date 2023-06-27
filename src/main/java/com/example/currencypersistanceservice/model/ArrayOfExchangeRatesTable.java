package com.example.currencypersistanceservice.model;

import lombok.Data;
import javax.validation.Valid;
import java.util.List;

@Data
public class ArrayOfExchangeRatesTable {
    @Valid
    private List<ExchangeRatesTable> exchangeRatesTable;
}

