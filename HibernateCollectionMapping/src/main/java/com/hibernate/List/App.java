package com.hibernate.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {

	static Scanner sc = new Scanner(System.in);
	SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {

		App app = new App();
		app.addEmployee();
	}

	public void addEmployee() {
		Session session = factory.openSession();
		Transaction tx = null;
		String firstName, lastName;
		int salary;
		sc = new Scanner(System.in);
		try {
			System.out.print("Enter First Name :");
			firstName = sc.next();
			System.out.print("Enter Last Name :");
			lastName = sc.next();
			System.out.print("Enter Salary :");
			salary = sc.nextInt();
			System.out.println("How many certificates you want to enter?");
			int num = sc.nextInt();
			List<Certificate> certificates = new ArrayList<Certificate>();
			for (int i = 0; i < num; i++) {
				System.out.println("Enter Certificate Name:");
				String certiName = sc.next();
				certificates.add(new Certificate(certiName));
			}
			Employee emp = new Employee();
			emp.setFirstName(firstName);
			emp.setLastName(lastName);
			emp.setSalary(salary);
			emp.setCertificates(certificates);
			tx = session.beginTransaction();
			session.save(emp);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
