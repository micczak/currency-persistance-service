package com.example.currencypersistanceservice.service.impl;


import com.example.currencypersistanceservice.model.CurrencyEntity;
import com.example.currencypersistanceservice.model.CurrencyInfoDto;
import com.example.currencypersistanceservice.repository.CurrencyRepository;
import com.example.currencypersistanceservice.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Override
    public void save(CurrencyInfoDto currencyInfoDto) {
        Optional<CurrencyEntity> existingCurrency = currencyRepository.findByCode(currencyInfoDto.getCode());
        // TODO: 11.07.2023 wykorzystać metody z Optionala ifPresent.orElse
        if (existingCurrency.isPresent()) {
            CurrencyEntity currencyToUpdate = existingCurrency.get();
            currencyToUpdate.setBid(currencyInfoDto.getBid());
            currencyToUpdate.setAsk(currencyInfoDto.getAsk());

            currencyRepository.save(currencyToUpdate);
        } else {
            CurrencyEntity currency = new CurrencyEntity();
            currency.setCode(currencyInfoDto.getCode());
            currency.setCurrency(currencyInfoDto.getCurrency());
            currency.setBid(currencyInfoDto.getBid());
            currency.setAsk(currencyInfoDto.getAsk());

            currencyRepository.save(currency);
        }

    }
// TODO: 11.07.2023 metoda update i save rozdzielić :D
    // TODO: 11.07.2023 TESTY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
}
