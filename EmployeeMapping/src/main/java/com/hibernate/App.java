package com.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

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
	private static Logger logger = Logger.getLogger(App.class.getName());

	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	static Scanner sc = new Scanner(System.in);
	int salary, id;

	public static void main(String[] args) {
		int n = 0;
		App app = new App();
		do {
			try {
				System.out.println("----------------------------------------");
				System.out.println("1. Add Employee");
				System.out.println("2. Update Employee");
				System.out.println("3. View Employee");
				System.out.println("4. Delete Employee");
				System.out.println("5. Exit");
				System.out.println("----------------------------------------");

				System.out.println("Enter your choice:");
				n = sc.nextInt();
				switch (n) {
				case 1:
					app.addEmployee();
					break;
				case 2:
					app.updateEmployee();
					break;
				case 3:
					app.viewEmployee();
					break;
				case 4:
					app.deleteEmployee();
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
			Employee emp = new Employee();
			emp.setFirstName(firstName);
			emp.setLastName(lastName);
			emp.setSalary(salary);
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

	private void deleteEmployee() {
		System.out.print("Enter student id to delete record :");
		id = sc.nextInt();
		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		Employee emp = session.get(Employee.class, id);
		session.delete(emp);
		tx.commit();
		session.close();
	}

	private void viewEmployee() {
		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List employee = session.createQuery("FROM Employee").list();
		System.out.println("Name \t\t" + "Salary ");
		System.out.println("---------------------------------");
		for (Iterator iterator = employee.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			System.out.print(emp.getFirstName() + " " + emp.getLastName() + "\t");
			System.out.print(emp.getSalary());
			System.out.print("\n");
		}
		session.close();
	}

	private void updateEmployee() {
		System.out.println("Enter employee Id:");
		id = sc.nextInt();

		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();

		Employee emp = session.get(Employee.class, id);
		System.out.println("Enter new salary value:");
		salary = sc.nextInt();
		emp.setSalary(salary);
		session.update(emp);
		tx.commit();
		session.close();
	}
}
