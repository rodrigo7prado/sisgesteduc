package com.rodrigo7prado.sisGestEduc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rodrigo7prado.sisGestEduc.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instanciateDatabase() {
		dbService.instanciateTestDatabase();
		return true;
	}
}
