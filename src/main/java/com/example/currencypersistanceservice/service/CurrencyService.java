package com.example.currencypersistanceservice.service;


import com.example.currencypersistanceservice.mapper.CurrencyMapper;
import com.example.currencypersistanceservice.model.CurrencyInfoDto;
import com.example.currencypersistanceservice.rabbit.CurrencyListener;
import com.example.currencypersistanceservice.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyMapper currencyMapper;
    private final CurrencyRepository currencyRepository;

    public void save(CurrencyInfoDto currencyInfoDto){

    }



    //TODO: provider(wypieprzyć to co niepotrzebne, ma być podpięty do nbp api i pobierać info o kursach.)
    //TODO jak pobierze infof z listy kursor ma wysłać na rabbita
    //TODO druga apka ma z rabbita pobierać wiaodmości , przemapować po pobrnaiu i wrzucić do bazy danych
    //TODO mapper zamienić na mapstruct
}
