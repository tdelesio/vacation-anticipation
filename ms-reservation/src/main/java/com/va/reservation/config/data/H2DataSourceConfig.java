package com.va.reservation.config.data;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.delesio.config.data.AbstractLocalDataSourceConfig;

//@Configuration
//@Profile("in-memory")
//@EnableJpaRepositories("com.va.reservation.repository.jpa")
public class H2DataSourceConfig extends AbstractLocalDataSourceConfig {

//	@Bean
//	public DataSource dataSource() {
//	return new EmbeddedDatabaseBuilder()
//	.setName("reservation")
//	.setType(EmbeddedDatabaseType.H2)
//	.build();
//	}
}
