package com.hibernate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//it indicates that this class can have multiple bean definitions
@Configuration
public class StudentConfig {

	// To get object
	@Bean
	public StudentImpl getStudentObject() {
		return new StudentImpl();
	}

}
