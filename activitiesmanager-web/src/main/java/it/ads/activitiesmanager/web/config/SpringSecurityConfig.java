package it.ads.activitiesmanager.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Class for Annotation Type Configuration
 * 
 * @author Paolo Porcedda
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DriverManagerDataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				/*.passwordEncoder(passwordEncoder())*/
				.usersByUsernameQuery("SELECT User.U_LOGIN,User.U_PWD AS password, TRUE AS ENABLED FROM User WHERE U_LOGIN=?")
				.authoritiesByUsernameQuery(	"SELECT User.U_LOGIN, Role.R_NAME AS ROLE "
											+	"FROM User, Role "
											+	"WHERE User.U_ROLE_ID = Role.ROLE_ID AND User.U_LOGIN=?");	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/", "/welcome/**").access("hasAuthority('WORKER') or hasAuthority('ADMINISTRATOR')")
		.antMatchers("/admin/**").access("hasAuthority('ADMINISTRATOR')")
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/welcome")
		.failureUrl("/login?error")
		.usernameParameter("login").passwordParameter("password")
		.and()
		.exceptionHandling().accessDeniedPage("/403")
		.and()
		.logout().logoutSuccessUrl("/login?logout").invalidateHttpSession(true);

	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}