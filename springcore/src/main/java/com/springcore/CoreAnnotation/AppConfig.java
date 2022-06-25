package com.springcore.CoreAnnotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.springcore.CoreAnnotation")
public class AppConfig {

	exampleInterface obj;

	// Using @Bean to create beans

	// @Bean
//	public Student getStudent() {
//		return new Student();
//	}
//
	// @Bean
//	public exampleInterface example() {
//		return new exampleImpl();
//	}

}
