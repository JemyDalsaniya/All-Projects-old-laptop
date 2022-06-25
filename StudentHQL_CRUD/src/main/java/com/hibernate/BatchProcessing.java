package com.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BatchProcessing {

	public static void main(String[] args) throws HibernateException {

		SessionFactory factory = new Configuration().configure().addPackage("com.hibernate")
				.addAnnotatedClass(Student.class).buildSessionFactory();

	}
}
