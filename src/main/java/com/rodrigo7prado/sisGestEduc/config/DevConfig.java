package com.rodrigo7prado.sisGestEduc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rodrigo7prado.sisGestEduc.services.DBService;
import com.rodrigo7prado.sisGestEduc.utils.ComplexCsv2DbInserter3;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instanciateDatabase() {
		
		if (!"create".equals(strategy)) {
			return false;
		}
		
		dbService.instanciateTestDatabase();
		new ComplexCsv2DbInserter3();
		return true;
	}
	
	public boolean aa() {
		return false;
		
	}
}
