package com.hibernate.StackXML;

import java.util.Scanner;
import java.util.logging.Logger;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private static Logger logger = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {
		// ApplicationContext context = new
		// AnnotationConfigApplicationContext(stackConfiguration.class);
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/hibernate/StackXML/config.xml");
		StackBean stack = context.getBean(StackBean.class);
		int n = 0;

		while (true) {

			Scanner sc = new Scanner(System.in);
			System.out.println("----------------------------------------");
			System.out.println("1. Push elements");
			System.out.println("2. Pop elements");
			System.out.println("3. View elements");
			System.out.println("4. Add element at specific position");
			System.out.println("5. Remove element from specific position");
			System.out.println("6. Exit");
			System.out.println("----------------------------------------");

			System.out.println("Enter your choice:");
			try {
				n = sc.nextInt();
				switch (n) {
				case 1:
					stack.pushElement();
					break;
				case 2:
					stack.popElement();
					break;
				case 3:
					stack.displayElements();
					break;
				case 4:
					stack.addAtPosition();
					break;
				case 5:
					stack.removeAtPosition();
					break;
				case 6:
					System.out.println("Out of the program...");
					System.exit(0);

				default:
					System.out.println("Please enter valid input!!");
					break;
				}

			} catch (Exception e) {
				logger.info("Enter valid input!!");
				sc.nextLine();
			}
		}
	}

}
