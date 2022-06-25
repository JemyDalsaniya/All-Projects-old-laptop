package com.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentImpl {

	private static Logger logger = Logger.getLogger(StudentImpl.class.getName());

	Scanner sc;
	int id, fees;
	String name, city;
	SessionFactory factory = new Configuration().configure().addPackage("com.hibernate")
			.addAnnotatedClass(Student.class).buildSessionFactory();

	public void addStudent() {

		Session session = factory.openSession();
		Transaction tx;
		sc = new Scanner(System.in);
		System.out.println("Enter Name:");
		name = sc.next();
		System.out.println("Enter City:");
		city = sc.next();
		System.out.println("Enter Fees:");
		fees = sc.nextInt();

		Student student = new Student();
		student.setName(name);
		student.setCity(city);
		student.setFees(fees);
		tx = session.beginTransaction();
		session.save(student);
		tx.commit();
		session.close();

	}

	public void updateStudent() {
		sc = new Scanner(System.in);
		System.out.println("Enter student Id:");
		id = sc.nextInt();

		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();

		Student student = session.get(Student.class, id);
		System.out.println("Enter new City value:");
		city = sc.next();
		student.setCity(city);
		session.update(student);
		tx.commit();
		session.close();

	}

	public void viewStudent() {

		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List students = session.createQuery("FROM Student").list();
		System.out.println("Name \t\t" + "City ");
		System.out.println("---------------------------------");
		for (Iterator iterator = students.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			System.out.print(student.getName());
			System.out.print(student.getCity());
			System.out.print("\n");
		}
		session.close();

	}

	public void deleteStudent() {
		sc = new Scanner(System.in);
		System.out.print("Enter student id to delete record :");
		id = sc.nextInt();
		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		tx.commit();
		session.close();
	}

}
