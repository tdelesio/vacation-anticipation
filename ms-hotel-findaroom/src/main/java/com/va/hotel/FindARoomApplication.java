package com.va.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = { "com.va.hotel.domain" })
@Configuration
@ComponentScan
public class FindARoomApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FindARoomApplication.class, args);
	}
}
