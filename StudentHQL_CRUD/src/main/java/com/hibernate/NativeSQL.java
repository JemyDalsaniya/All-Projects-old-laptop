package com.hibernate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class NativeSQL {

	@SuppressWarnings({ "rawtypes", "deprecation" })
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addPackage("com.hibernate")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Scanner sc = new Scanner(System.in);

		tx = session.beginTransaction();
		NativeQuery query = session.createSQLQuery("SELECT name, fees FROM student");
		// query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Object[]> data = query.list();

		for (Object[] object : data) {
			// Map row = (Map) object;
			System.out.println(Arrays.deepToString(object));
//			System.out.print(" Name: " + row.get("name"));
//			System.out.println(", Salary: " + row.get("fees"));
		}

		SQLQuery query1 = session.createSQLQuery("SELECT * FROM Student");
		query1.addEntity(Student.class);
		List students = query1.list();

		for (Iterator iterator = students.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			System.out.print("Name: " + student.getName());
			System.out.println("Fees: " + student.getFees());
		}
		tx.commit();

	}

}
