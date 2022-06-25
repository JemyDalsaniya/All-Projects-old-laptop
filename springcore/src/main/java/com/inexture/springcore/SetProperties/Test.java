package com.inexture.springcore.SetProperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/inexture/springcore/setProperties/config.xml");
		Example ex = context.getBean("example", Example.class);
		// System.out.println(ex);
		ex.msg();
	}

}
