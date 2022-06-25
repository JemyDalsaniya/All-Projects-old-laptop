package com.inexture.springcore.reference;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/inexture/springcore/reference/configReference.xml");
		A object = (A) context.getBean("aReference");
		System.out.println(object.getX());
		System.out.println(object.getObj().getY());
		System.out.println(object);
	}

}
