package com.example.currencypersistanceservice.rabbit;

import com.example.currencypersistanceservice.model.CurrencyInfoDto;
import com.example.currencypersistanceservice.service.impl.CurrencyServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CurrencyListener {

    private final CurrencyServiceImpl currencyServiceImpl;

    @RabbitListener(queues = "test_queue")
    public void receiveMessage(CurrencyInfoDto currencyInfoDto) {
        log.info("Received: " + currencyInfoDto);
        currencyServiceImpl.save(currencyInfoDto);
    }
}
