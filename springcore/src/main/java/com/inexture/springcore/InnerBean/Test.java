package com.inexture.springcore.InnerBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author JEMMY
 *
 */
public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/inexture/springcore/InnerBean/config.xml");
		Student student = context.getBean("student11", Student.class);
		System.out.println(student.getStudentId());
		System.out.println(student.getStudentName());
		System.out.println(student.getAddress());
		Address address = student.getAddress();
		System.out.println(address.getAddId());
		System.out.println(address.getCity());

	}
}
