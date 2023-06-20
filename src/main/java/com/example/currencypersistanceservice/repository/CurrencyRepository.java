package com.example.currencypersistanceservice.repository;

import com.example.currencypersistanceservice.model.CurrencyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyInfo, String> {

}
