package com.inexture.springcore;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/inexture/springcore/config.xml");
		Scanner sc = new Scanner(System.in);
		StackImplimentation stackVal = context.getBean("stackImpl", StackImplimentation.class);
		// System.out.println(stackVal);
		List<Integer> m = stackVal.display();
		System.out.println("array list values:" + m);
		System.out.println("Enter element that you want to delete: ");
		int val = sc.nextInt();
		for (int i = 0; i < m.size(); i++) {
			if (m.contains(val)) {
				continue;
			}
			System.out.println(m);
		}

		sc.close();
	}
}
