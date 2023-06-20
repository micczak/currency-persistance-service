package com.example.currencypersistanceservice.mapper;

import com.example.currencypersistanceservice.model.CurrencyInfo;
import com.example.currencypersistanceservice.model.CurrencyInfoDto;

public class CurrencyMapper {

    public CurrencyInfo fromDto(CurrencyInfoDto currencyInfoDto){
        CurrencyInfo currencyInfo = new CurrencyInfo();
        currencyInfo.setCode(currencyInfoDto.getCode());
        currencyInfo.setCurrency(currencyInfoDto.getCurrency());
        currencyInfo.setBid(currencyInfoDto.getBid());
        currencyInfo.setAsk(currencyInfoDto.getAsk());
        return currencyInfo;
    }

}
