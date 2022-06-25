package com.inexture.springcore.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/inexture/springcore/collections/collectionConfig.xml");
		Employee emp = (Employee) context.getBean("emp1");
		System.out.println(emp);

	}

}
