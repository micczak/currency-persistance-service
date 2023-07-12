package com.example.currencypersistanceservice.service.impl;

import com.example.currencypersistanceservice.model.CurrencyEntity;
import com.example.currencypersistanceservice.model.CurrencyInfoDto;
import com.example.currencypersistanceservice.repository.CurrencyRepository;
import com.example.currencypersistanceservice.service.CurrencyService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CurrencyServiceIntegrationTest {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyService currencyService;

    @Test
    void testSaveNewCurrency() {
        CurrencyInfoDto currencyInfoDto = new CurrencyInfoDto();
        currencyInfoDto.setCode("USD");
        currencyInfoDto.setCurrency("Dollar");
        currencyInfoDto.setBid(new BigDecimal("0.5"));
        currencyInfoDto.setAsk(new BigDecimal("1.5"));

        currencyService.save(currencyInfoDto);

        Optional<CurrencyEntity> currencyEntity = currencyRepository.findByCode("USD");

        Assert.assertTrue(currencyEntity.isPresent());
        Assert.assertEquals("USD", currencyEntity.get().getCode());
        Assert.assertEquals("Dollar", currencyEntity.get().getCurrency());
        Assert.assertEquals(0, new BigDecimal("0.5").compareTo(currencyEntity.get().getBid()));
        Assert.assertEquals(0, new BigDecimal("1.5").compareTo(currencyEntity.get().getAsk()));

    }
}