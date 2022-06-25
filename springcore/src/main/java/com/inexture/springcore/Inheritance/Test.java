package com.inexture.springcore.Inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/inexture/springcore/Inheritance/config.xml");
		Student student = context.getBean("student", Student.class);
		Teacher teacher = context.getBean("teacher", Teacher.class);

		System.out.println(student);
		System.out.println(teacher);

	}

}
