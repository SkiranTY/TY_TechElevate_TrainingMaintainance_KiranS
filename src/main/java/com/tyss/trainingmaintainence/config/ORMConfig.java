package com.tyss.trainingmaintainence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class ORMConfig {

	@Bean
	public LocalEntityManagerFactoryBean ormConfiguration() {
		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("Training-maintenece");
		return bean;
	}
}
