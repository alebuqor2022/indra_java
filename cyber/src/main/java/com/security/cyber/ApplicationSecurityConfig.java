package com.security.cyber;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	protected UserDetailsService userDetailsService() {
		List<UserDetails> users=new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().
				username("ale").password("1234").roles("USER").build());
		users.add(User.withDefaultPasswordEncoder().
				username("admin").password("admin").roles("USER").build());
		
		return new InMemoryUserDetailsManager(users);
		
	}
}
