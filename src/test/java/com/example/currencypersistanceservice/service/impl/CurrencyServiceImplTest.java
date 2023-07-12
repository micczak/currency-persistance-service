package com.example.currencypersistanceservice.service.impl;

import com.example.currencypersistanceservice.model.CurrencyEntity;
import com.example.currencypersistanceservice.model.CurrencyInfoDto;
import com.example.currencypersistanceservice.repository.CurrencyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class CurrencyServiceImplTest {

    @Mock
    private CurrencyRepository currencyRepository;

    @InjectMocks
    private CurrencyServiceImpl currencyService;

    @Test
    void testSaveNewCurrency() {
        CurrencyInfoDto currencyInfoDto = new CurrencyInfoDto();
        currencyInfoDto.setCode("USD");
        currencyInfoDto.setCurrency("Dollar");
        currencyInfoDto.setBid(new BigDecimal("0.5"));
        currencyInfoDto.setAsk(new BigDecimal("1.5"));

        when(currencyRepository.findByCode("USD")).thenReturn(Optional.empty());

        currencyService.save(currencyInfoDto);

        ArgumentCaptor<CurrencyEntity> captor = ArgumentCaptor.forClass(CurrencyEntity.class);

        verify(currencyRepository, times(1)).save(captor.capture());

        CurrencyEntity savedCurrency = captor.getValue();

        assertEquals("USD", savedCurrency.getCode());
        assertEquals("Dollar", savedCurrency.getCurrency());
        assertEquals(new BigDecimal("0.5"), savedCurrency.getBid());
        assertEquals(new BigDecimal("1.5"), savedCurrency.getAsk());
    }

    @Test
    void testUpdateExistingCurrency() {
        CurrencyInfoDto currencyInfoDto = new CurrencyInfoDto();
        currencyInfoDto.setCode("USD");
        currencyInfoDto.setCurrency("Dollar");
        currencyInfoDto.setBid(new BigDecimal("0.6"));
        currencyInfoDto.setAsk(new BigDecimal("1.6"));

        CurrencyEntity existingCurrency = new CurrencyEntity();
        existingCurrency.setCode("USD");
        existingCurrency.setCurrency("Dollar");
        existingCurrency.setBid(new BigDecimal("0.5"));
        existingCurrency.setAsk(new BigDecimal("1.5"));

        when(currencyRepository.findByCode("USD")).thenReturn(Optional.of(existingCurrency));

        currencyService.save(currencyInfoDto);

        ArgumentCaptor<CurrencyEntity> captor = ArgumentCaptor.forClass(CurrencyEntity.class);

        verify(currencyRepository, times(1)).save(captor.capture());

        CurrencyEntity updatedCurrency = captor.getValue();

        assertEquals("USD", updatedCurrency.getCode());
        assertEquals("Dollar", updatedCurrency.getCurrency());
        assertEquals(new BigDecimal("0.6"), updatedCurrency.getBid());
        assertEquals(new BigDecimal("1.6"), updatedCurrency.getAsk());
    }
}
