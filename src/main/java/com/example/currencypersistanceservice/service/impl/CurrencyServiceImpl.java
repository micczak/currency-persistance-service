package com.example.currencypersistanceservice.service.impl;


import com.example.currencypersistanceservice.client.NbpClient;
import com.example.currencypersistanceservice.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final NbpClient nbpClient;

    @Override
    public void loadCurrencies(){

    }
}
