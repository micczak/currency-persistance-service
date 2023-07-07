package com.example.currencypersistanceservice.service;

import com.example.currencypersistanceservice.model.CurrencyInfoDto;

public interface CurrencyService {

    void loadCurrencies();

    void save(CurrencyInfoDto currencyInfoDto);
}
