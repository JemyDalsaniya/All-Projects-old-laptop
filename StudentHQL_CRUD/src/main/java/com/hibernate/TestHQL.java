package com.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TestHQL {

	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addPackage("com.hibernate")
				.addAnnotatedClass(Student.class).addAnnotatedClass(NewStudent.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Scanner sc = new Scanner(System.in);

		// FROM clause
		Query query = session.createQuery("FROM Student");
		System.out.println(query);
		List results = query.list();
		System.out.println("From Clause" + results + "\n");

		// AS Clause
		Query queryAs = session.createQuery("FROM Student AS E");
		List resultsAs = queryAs.list();
		System.out.println("AS Clause" + resultsAs + "\n");

		// SELECT Clause
		Query querySelect = session.createQuery("SELECT E.name FROM Student E");
		List resultsSelect = querySelect.list();
		System.out.println("SELECT Clause" + resultsSelect + "\n");

		// WHERE Clause
		Query queryWhere = session.createQuery("FROM Student E WHERE E.id = 1");
		List resultsWhere = queryWhere.list();
		System.out.println("WHERE Clause" + resultsWhere + "\n");

//		ORDER BY Clause
		Query queryOrderBy = session.createQuery("FROM Student E WHERE E.id > 3 ORDER BY E.fees DESC");
		List resultsOrderBy = queryOrderBy.list();
		System.out.println("ORDER BY Clause" + resultsOrderBy + "\n");

		// GROUP BY Clause
		Query queryGroupBy = session.createQuery("SELECT SUM(E.fees), E.name FROM Student E " + "GROUP BY E.name");
		List resultsGroupBy = queryGroupBy.list();
		System.out.println("GROUP BY Clause" + resultsGroupBy + "\n");

		// Aggregate Methods
		Query aggQuery = session.createQuery(
				"SELECT count(E.id), avg(E.fees), max(E.fees), min(E.fees), sum(E.fees),count(distinct E.name) FROM Student E");
		System.out.println("Aggregate methods" + "\n");
		List aggregateList = aggQuery.list();
		for (Iterator iterator = aggregateList.iterator(); iterator.hasNext();) {
			Object[] row = (Object[]) iterator.next();
			System.out.println("Average Of fees = " + row[1]);
			System.out.println("Count Of Students = " + row[0]);
			System.out.println("Maximum fees = " + row[2]);
			System.out.println("Minimum fees = " + row[3]);
			System.out.println("Sum Of fees = " + row[4]);
			System.out.println("Distinct Names = " + row[5]);

		}

		// Using Named Parameters
		Query namedQuery = session.createQuery("FROM Student E WHERE E.id = :sid");
		System.out.println("Using Named Parameters");
		System.out.print("Enter Id :");
		int id = sc.nextInt();
		List resultsName = namedQuery.setParameter("sid", id).list();
		System.out.println(resultsName);

		// UPDATE Clause
//		Query queryUpdate = session.createQuery("UPDATE Student set city = :city WHERE id = :sid");
//		System.out.println("Enter Id to Update");
//		int idUpdate = sc.nextInt();
//		System.out.println("Enter new city");
//		String cityUpdate = sc.next();
//		queryUpdate.setParameter("sid", idUpdate);
//		queryUpdate.setParameter("city", cityUpdate);
//		tx = session.beginTransaction();
//		int result = queryUpdate.executeUpdate();
//		tx.commit();
//		System.out.println("Rows affected: " + result);

		// DELETE Clause
//		Query queryDelete = session.createQuery("DELETE FROM Student " + "WHERE id = :sid");
//		System.out.println("Enter Id to Delete");
//		int idDelete = sc.nextInt();
//		queryDelete.setParameter("sid", idDelete);
//		tx = session.beginTransaction();
//		int resultDelete = queryDelete.executeUpdate();
//		tx.commit();
//		System.out.println("Rows affected: " + resultDelete);

		// INSERT Clause
//		Query queryInsert = session
//				.createQuery("INSERT INTO NewStudent(name, city, fees)" + "SELECT name, city, fees FROM Student");
//		tx = session.beginTransaction();
//		int resultInsert = queryInsert.executeUpdate();
//		tx.commit();
//		System.out.println("Rows affected: " + resultInsert);

		// Pagination
		System.out.println("Pagination:");
		Query paginationquery = session.createQuery("FROM Student");
		paginationquery.setFirstResult(3);
		paginationquery.setMaxResults(4);
		List<Student> student = paginationquery.list();

		for (Iterator<Student> iterator = student.iterator(); iterator.hasNext();) {
			Student obj = iterator.next();
			System.out.print(obj.getSid() + " ");
			System.out.print(obj.getName() + " ");
			System.out.print(obj.getCity() + " ");
			System.out.print(obj.getFees() + " ");
			System.out.println();

		}

	}

}
