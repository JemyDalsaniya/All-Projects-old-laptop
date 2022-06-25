package com.hibernate;

import java.util.Scanner;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	private static Logger logger = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
		StudentImpl student = context.getBean(StudentImpl.class);
		Scanner sc = new Scanner(System.in);
		int n = 0;

		do {
			try {

				System.out.println("----------------------------------------");
				System.out.println("1. Add Student");
				System.out.println("2. Update Student");
				System.out.println("3. View Student");
				System.out.println("4. Delete Student");
				System.out.println("5. Exit");
				System.out.println("----------------------------------------");

				System.out.println("Enter your choice:");
				n = sc.nextInt();
				switch (n) {
				case 1:
					student.addStudent();
					break;
				case 2:
					// System.out.println("case2");
					student.updateStudent();
					break;
				case 3:
					student.viewStudent();
					break;
				case 4:
					student.deleteStudent();
					break;
				case 5:
					System.out.println("Out of the program...");
					System.exit(0);

				default:
					System.out.println("Please enter valid input!!");
				}

			} catch (Exception e) {
				logger.info("Enter valid input!!");
				sc.nextLine();
			}
		} while (n != 5);
	}
}
