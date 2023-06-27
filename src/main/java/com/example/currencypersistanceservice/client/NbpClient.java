package com.example.currencypersistanceservice.client;

import com.example.currencypersistanceservice.model.Currencies;
import com.example.currencypersistanceservice.model.ExchangeResult;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface NbpClient {

        @RequestLine("GET /symbols")
        @Headers("apikey: {apiKey}")
        Currencies findAllCurrencies(@Param("apiKey") String apiKey);

        @RequestLine("GET /convert?to={to}&from={from}&amount={amount}")
        @Headers("apikey: {apiKey}")
        ExchangeResult convertCurrency(
                @Param("apiKey") String apiKey,
                @Param("to") String to,
                @Param("from") String from,
                @Param("amount") double amount
        );
}