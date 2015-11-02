package com.va.reservation.config.data;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.delesio.config.data.AbstractLocalDataSourceConfig;

//@Configuration
//@Profile("mysql-local")
public class MySqlLocalDataSourceConfig extends AbstractLocalDataSourceConfig {

//	 @Bean
//	 public DataSource dataSource() {
//		 return createBasicDataSource("jdbc:mysql://localhost/reservation", "com.mysql.jdbc.Driver", "", "");
//	 }

}
