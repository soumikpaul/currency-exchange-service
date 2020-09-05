package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long>{

	ExchangeValue findByFromAndTo(String from,String to);
}
