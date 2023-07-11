package com.example.currencypersistanceservice.rabbit;

import com.example.currencypersistanceservice.model.CurrencyInfoDto;
import com.example.currencypersistanceservice.service.CurrencyService;
import com.example.currencypersistanceservice.service.impl.CurrencyServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class CurrencyListener {

    private final CurrencyService currencyService;
    private final ObjectMapper objectMapper;
    @RabbitListener(queues = "newCurrencies")
    public void receiveMessage(byte[] payload) {
      try {
          CurrencyInfoDto currencyInfoDto = objectMapper.readValue(payload, CurrencyInfoDto.class);
          log.info("Received: " + currencyInfoDto);
          currencyService.save(currencyInfoDto);
      } catch (IOException e){
          log.error("błąd");
      }
    }
}
