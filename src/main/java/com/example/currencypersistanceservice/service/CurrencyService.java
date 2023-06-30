package com.example.currencypersistanceservice.service;

import com.example.currencypersistanceservice.model.CurrencyInfo;
import com.example.currencypersistanceservice.model.ExchangeResult;
import com.example.currencypersistanceservice.model.PropertiesDto;

public interface CurrencyService {

    ExchangeResult convert(String to, String from, double amount);

    PropertiesDto getProperties();

    CurrencyInfo getAllCurrencies();
}
