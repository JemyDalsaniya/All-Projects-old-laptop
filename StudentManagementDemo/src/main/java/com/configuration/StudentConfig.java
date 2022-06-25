package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dao.StudentImpl;

@Configuration
public class StudentConfig {
	@Bean
	public StudentImpl getStudentObject() {
		return new StudentImpl();
	}
}
