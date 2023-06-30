package com.example.currencypersistanceservice.controller;

import com.example.currencypersistanceservice.model.PropertiesDto;
import com.example.currencypersistanceservice.service.impl.CurrencyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

public class CurrencyController {

    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/api/v1/exchange")
    public class ExchangeController {
        private final CurrencyServiceImpl currencyServiceImpl;


        @GetMapping("/properties")
        public ResponseEntity<PropertiesDto> getProperties() {
            return new ResponseEntity<>(currencyServiceImpl.getProperties(), HttpStatus.OK);
        }

        @GetMapping("/symbols")
        public ResponseEntity<Currencies> getAllCurrencies() {
            return new ResponseEntity<>(currencyServiceImpl.getAllCurrencies(), HttpStatus.OK);
        }

        @Secured({"ROLE_ADMIN", "ROLE_USER"})
        @PostMapping(value = "/convert", params = "mail")
        public ResponseEntity<Void> convertAndSend(@RequestBody Query query, @RequestParam String mail
        ) {
            CurrencyServiceImpl exchangeResult = currencyServiceImpl.convert(query, mail);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @Secured({"ROLE_ADMIN"})
        @GetMapping("/convert")
        public ResponseEntity<CurrencyServiceImpl> convert(
                @RequestParam String to,
                @RequestParam String from,
                @RequestParam double amount
        ) {
            CurrencyServiceImpl result = currencyServiceImpl.convert(to, from, amount);
            if (result.isSuccess()) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
