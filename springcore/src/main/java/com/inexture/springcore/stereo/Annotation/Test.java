package com.inexture.springcore.stereo.Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/inexture/springcore/stereo/Annotation/configStereo.xml");
		Student s1 = context.getBean("jemy", Student.class);
		System.out.println(s1);
		System.out.println(s1.getStudentAddress().getClass().getName());
		System.out.println(s1.hashCode());
		System.out.println("----------------------------------------------------");
		Student s2 = context.getBean("jemy", Student.class);
		System.out.println(s2.hashCode());

		Teacher teacher1 = context.getBean("teacher", Teacher.class);
		System.out.println(teacher1.hashCode());
		Teacher teacher2 = context.getBean("teacher", Teacher.class);
		System.out.println(teacher2.hashCode());

	}

}
