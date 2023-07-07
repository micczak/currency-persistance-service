package com.example.currencypersistanceservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class CurrencyPersistanceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyPersistanceServiceApplication.class, args);
	}

}
