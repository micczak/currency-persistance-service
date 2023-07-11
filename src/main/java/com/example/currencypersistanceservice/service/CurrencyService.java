package com.example.currencypersistanceservice.service;

import com.example.currencypersistanceservice.model.CurrencyEntity;
import com.example.currencypersistanceservice.model.CurrencyInfoDto;

import java.util.List;

public interface CurrencyService {

    void save(CurrencyInfoDto currencyInfoDto);
}
