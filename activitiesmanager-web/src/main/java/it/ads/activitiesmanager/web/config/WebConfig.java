package it.ads.activitiesmanager.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import it.ads.activitiesmanager.service.config.ServiceConfig;

/**
 * Class for Annotation Type Configuration
 * 
 * @author Paolo Porcedda
 *
 */
@Configuration
@PropertySource("classpath:db.properties")
@PropertySource("classpath:general.properties")
@Import(ServiceConfig.class)
@ComponentScan(basePackages = { "it.ads.activitiesmanager.web", "it.ads.activitiesmanager.service", "it.ads.activitiesmanager.model" })
public class WebConfig {
	
	@Autowired
	private Environment env;
	
	/*
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(env.getRequiredProperty("db.jdbcurl"), env.getRequiredProperty("db.username"),env.getRequiredProperty("db.password"));
		dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
		return dataSource;
	}
	*/
}
