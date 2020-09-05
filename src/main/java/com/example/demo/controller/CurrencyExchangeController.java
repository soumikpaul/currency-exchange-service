package com.example.demo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
//import org.springframework.cloud.config.environment.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ExchangeValue;
import com.example.demo.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	@Autowired
	private ExchangeValueRepository repo;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		//ExchangeValue exchangeVal=new ExchangeValue(1,from,to,BigDecimal.valueOf(65));
		
		ExchangeValue exchangeVal=repo.findByFromAndTo(from, to);

		exchangeVal.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeVal;
	}

}
