package com.dao;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.model.Student;

public class StudentImpl {

	private static Logger logger = Logger.getLogger(StudentImpl.class.getName());

	Scanner sc;
	int id;
	String fname, lname;
	SessionFactory factory = new Configuration().configure().addPackage("com.model").addAnnotatedClass(Student.class)
			.buildSessionFactory();

	public void addStudent(Student student) {

		Session session = factory.openSession();
		Transaction tx;
		System.out.println(student);
		tx = session.beginTransaction();
		session.save(student);
		tx.commit();
		System.out.println("student added sucessfully.............");
		session.close();

	}

	public List<Student> getDetails(int id) {

		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		Query query = session.createQuery("FROM Student where id=:id");
		List students = query.setParameter("id", id).list();
		System.out.println("students:" + students);
		session.close();
		return students;
	}

	public void updateStudent(Student student) {
		System.out.println(student);
		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		// Student student1 = session.get(Student.class, student.getId());
		session.update(student);
		tx.commit();
		session.close();

	}

	public List<Student> viewStudent() {

		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List students = session.createQuery("FROM Student").list();
		session.close();
		return students;

	}

	public void deleteStudent(int id) {

		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		tx.commit();
		session.close();
	}

}
