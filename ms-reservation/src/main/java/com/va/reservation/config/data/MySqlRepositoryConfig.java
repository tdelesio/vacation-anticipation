package com.va.reservation.config.data;

import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.delesio.config.data.AbstractJpaRepositoryConfig;

//@Configuration
//@Profile("mysql")
//@EnableJpaRepositories("com.va.reservation.repository.jpa")
public class MySqlRepositoryConfig {//extends AbstractJpaRepositoryConfig {

//	@Override
//	protected String getDomainPackage() {
//		return "com.va.reservation.domain";
//	}
//
//	@Override
//	protected String getHibernateDialect() {
//		 return MySQL5Dialect.class.getName();
//	}

}
