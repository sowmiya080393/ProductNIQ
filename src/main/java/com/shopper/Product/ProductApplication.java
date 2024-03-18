package com.shopper.Product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;


@EnableJpaRepositories
@SpringBootApplication
@Slf4j
public class ProductApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}}


