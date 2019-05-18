package com.shoping.myshopingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemApplication.class,args);
	}
}
       