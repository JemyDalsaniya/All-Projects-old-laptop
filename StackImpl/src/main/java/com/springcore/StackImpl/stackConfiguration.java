package com.springcore.StackImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//it indicates that this class can have multiple bean definitions
@Configuration
public class stackConfiguration {

	// To get object
	@Bean
	public StackBean getStackImplObject() {
		return new StackBean();
	}
}
