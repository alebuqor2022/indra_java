package com.indra.spring.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	// reemplaza el archivo beans.xml
	
	@Bean
	public HolaMundo mundo() {
		return new HolaMundo();
	}
	
	@Bean
	public HolaMundo marte() {
		return new HolaMundo();
	}

}
