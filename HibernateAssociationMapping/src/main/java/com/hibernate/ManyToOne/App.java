package com.hibernate.ManyToOne;

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

		System.out.println("Enter Street :");
		String street = sc.next();
		System.out.println("Enter City :");
		String city = sc.next();
		System.out.println("Enter State :");
		String state = sc.next();
		System.out.println("Enter Pincode :");
		String pin = sc.next();

		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZipcode(pin);
		session.save(address);

		System.out.println(" How Many Employee You Want To Insert :");

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
			emp.setAddress(address);
			session.save(emp);

		}

		session.getTransaction().commit();
		session.close();
	}
}
