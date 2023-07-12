package com.example.currencypersistanceservice.service.impl;


import com.example.currencypersistanceservice.model.CurrencyEntity;
import com.example.currencypersistanceservice.model.CurrencyInfoDto;
import com.example.currencypersistanceservice.repository.CurrencyRepository;
import com.example.currencypersistanceservice.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Override
    public void save(CurrencyInfoDto currencyInfoDto) {
        currencyRepository.findByCode(currencyInfoDto.getCode())
                .ifPresentOrElse(
                        currency -> updateCurrency(currency, currencyInfoDto),
                        () -> saveNewCurrency(currencyInfoDto));
    }

    private void updateCurrency(CurrencyEntity currency, CurrencyInfoDto currencyInfoDto) {
        currency.setBid(currencyInfoDto.getBid());
        currency.setAsk(currencyInfoDto.getAsk());
        currencyRepository.save(currency);
    }

    private void saveNewCurrency(CurrencyInfoDto currencyInfoDto) {
        CurrencyEntity newCurrency = new CurrencyEntity();
        newCurrency.setCode(currencyInfoDto.getCode());
        newCurrency.setCurrency(currencyInfoDto.getCurrency());
        newCurrency.setBid(currencyInfoDto.getBid());
        newCurrency.setAsk(currencyInfoDto.getAsk());
        currencyRepository.save(newCurrency);
    }
}

