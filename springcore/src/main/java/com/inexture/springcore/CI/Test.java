package com.inexture.springcore.CI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/inexture/springcore/CI/configCI.xml");
		Person person = (Person) context.getBean("person");
		System.out.println(person);
	}
}
