package com.hibernate.SortedSet;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

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
		app.viewEmployee();
	}

	public void viewEmployee() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM Employee").list();
			for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();) {
				Employee employee = (Employee) iterator1.next();
				System.out.print("First Name: " + employee.getFirstName());
				System.out.print("  Last Name: " + employee.getLastName());
				System.out.println("  Salary: " + employee.getSalary());
				SortedSet certificates = employee.getCertificates();
				for (Iterator iterator2 = certificates.iterator(); iterator2.hasNext();) {
					Certificate certName = (Certificate) iterator2.next();
					System.out.println("Certificate: " + certName.getName());
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
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
			TreeSet<Certificate> certificates = new TreeSet<Certificate>();
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
