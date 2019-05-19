package com.shoping.myshopingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class SupplierAplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierAplication.class, args);
		// TODO Auto-generated method stub

	}

}
