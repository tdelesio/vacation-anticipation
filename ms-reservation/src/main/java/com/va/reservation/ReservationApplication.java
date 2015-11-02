package com.va.reservation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudException;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.va.reservation.config.AppConfig;

//@EnableAutoConfiguration
//@EnableJpaRepositories(basePackages = { "com.va.reservation.domain" })
@Configuration
@ComponentScan
public class ReservationApplication {

	static Logger logger = LoggerFactory
			.getLogger(ReservationApplication.class);

	public static void main(String[] args) throws Exception {

		SpringApplication application = new SpringApplication(AppConfig.class);
		String activeProfile = getProfile();
		System.out
				.println("Starting application with profile " + activeProfile);
		application.setAdditionalProfiles(activeProfile);
		application.run(args);
	}
//	public static void main(String[] args) throws Exception {
//		SpringApplication.run(ReservationApplication.class, args);
//	}

	private static String getProfile() {
		String profile = null;
		Cloud cloud = getCloud();
		if (cloud == null) {
			profile = "local";
		} else {
			profile = "cloud";
		}
		return profile;
	}

	private static Cloud getCloud() {
		try {
			CloudFactory cloudFactory = new CloudFactory();
			return cloudFactory.getCloud();
		} catch (CloudException ce) {
			return null;
		}
	}
}
