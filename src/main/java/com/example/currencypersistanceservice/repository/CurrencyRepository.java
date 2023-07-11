package com.example.currencypersistanceservice.repository;

import com.example.currencypersistanceservice.model.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, String> {
    Optional<CurrencyEntity> findByCode(String code);
}

