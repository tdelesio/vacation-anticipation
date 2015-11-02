package com.va.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.delesio.filter.SimpleCORSFilter;


@EnableAutoConfiguration
@EnableJpaRepositories(basePackages={"com.va.hotel.domain"})
@Configuration
@ComponentScan(basePackageClasses=SimpleCORSFilter.class)
@Import(RepositoryRestMvcConfiguration.class)
public class HotelApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(HotelApplication.class, args);
	}
}
