package com.hibernate.ManyToMany;

import java.util.HashSet;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		HashSet<Certificate> certificates = new HashSet<Certificate>();
		System.out.println("How many certificate you want to add?");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter Certificate Name:");
			String certiName = sc.next();
			certificates.add(new Certificate(certiName));
		}

		System.out.println(" How Many Employee You Want To Insert?");

		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			Employee emp = new Employee();

			System.out.println("Enter First Name :");
			String firstName = sc.next();
			System.out.println("Enter Last Name :");
			String lastName = sc.next();
			System.out.println("Enter Salary");
			int salary = sc.nextInt();

			emp.setFirstName(firstName);
			emp.setLastName(lastName);
			emp.setSalary(salary);
			emp.setCertificates(certificates);
			session.save(emp);

		}

		session.getTransaction().commit();
		session.close();
	}
}
