package it.ads.activitiesmanager.service.config;

import it.ads.activitiesmanager.model.config.ModelConfig;
import it.ads.activitiesmanager.service.IUserDS;
import it.ads.activitiesmanager.service.impl.UserDSImpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;


/**
* Class for Annotation Type Configuration
* @author Paolo Porcedda
*
*/
@Configuration
@Import(ModelConfig.class)
@EnableWebSecurity
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = { "it.ads.activitiesmanager.service", "it.ads.activitiesmanager.model" })
//@Profile("production")
public class ServiceConfig {
	
	@Bean
	public IUserDS getUserDS() {  
		return new UserDSImpl();  
	}
	
	@Autowired
	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication().withUser("login").password("password").roles("WORKER");
	  }
	
	
}