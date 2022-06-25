package com.hibernate.BatchProcessing;

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
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addPackage("com.hibernate")
				.addAnnotatedClass(Employee.class).buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;

		try {
			tx = session.beginTransaction();
			for (int i = 0; i < 10; i++) {
				String fname = "First Name " + i;
				String lname = "Last Name " + i;
				Integer salary = i;
				Employee employee = new Employee(fname, lname, salary);
				session.save(employee);
				if (i % 5 == 0) {
					session.flush();
					System.out.println("flush done!!");
					session.clear();
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
}
