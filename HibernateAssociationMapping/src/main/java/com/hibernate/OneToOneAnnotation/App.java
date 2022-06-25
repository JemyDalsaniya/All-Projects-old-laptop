package com.hibernate.OneToOneAnnotation;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		// SessionFactory factory = new
		// Configuration().configure().buildSessionFactory();
		SessionFactory factory = new Configuration().configure().addPackage("com.hibernate")
				.addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class).buildSessionFactory();

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
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(address);
		session.save(emp);
		tx.commit();
		session.close();
	}
}
