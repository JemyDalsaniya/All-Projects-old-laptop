package com.inexture.springcore.Fruit;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		System.out.println("hello");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"com/inexture/springcore/Fruit/configLifecycle.xml");
		context.registerShutdownHook();
//		Fruits fruit1 = (Fruits) context.getBean("fruit1");
//		Pets pet1 = (Pets) context.getBean("pet1");
//		System.out.println(fruit1);
//		System.out.println(pet1);
		Example ex = (Example) context.getBean("example");
		System.out.println(ex);
	}
}