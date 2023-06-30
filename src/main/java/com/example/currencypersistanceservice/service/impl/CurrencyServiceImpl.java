package com.example.currencypersistanceservice.service.impl;


import com.example.currencypersistanceservice.client.NbpClient;
import com.example.currencypersistanceservice.model.CurrencyInfo;
import com.example.currencypersistanceservice.model.ExchangeResult;
import com.example.currencypersistanceservice.model.PropertiesDto;
import com.example.currencypersistanceservice.model.ExchangeApiProperties;
import com.example.currencypersistanceservice.service.CurrencyService;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final ExchangeApiProperties properties;
    private final NbpClient nbpClient;

    @Override
    public ExchangeResult convert(String to, String from, double amount) {
        return nbpClient.convertCurrency(properties.getApiKey(), to, from, amount);
    }

    @Override
    public ExchangeResult convert(Query query) {
        return null;
    }


    @Override
    public PropertiesDto getProperties() {
        return new PropertiesDto(properties.getApiKey(), properties.getBaseUrl());
    }

    @Override
    public CurrencyInfo getAllCurrencies() {
        return nbpClient.findAllCurrencies(properties.getApiKey());
    }
}
