package com.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class TestCriteria {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addPackage("com.hibernate")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		Criteria cr = session.createCriteria(Student.class);

		// Use of gt
		// cr.add(Restrictions.gt("fees", 30000));

		// Use of lt
		// cr.add(Restrictions.lt("fees", 20000));

		// To get records having fistName starting with zara
		// cr.add(Restrictions.like("name", "sh%"));

		// To get records having salary in between 1000 and 2000
		// cr.add(Restrictions.between("fees", 20000, 40000));

		// To check if the given property is null
		// cr.add(Restrictions.isNull("fees"));

		// To check if the given property is not null
		// cr.add(Restrictions.isNotNull("fees"));

//		List results = cr.list();
//		System.out.println(results);

		Criteria cr1 = session.createCriteria(Student.class);

		Criterion fees = Restrictions.gt("fees", 20000);
		Criterion name = Restrictions.ilike("name", "je%");

		// To get records matching with OR conditions
//		LogicalExpression orExp = Restrictions.or(fees, name);
//		cr1.add(orExp);

		// To get records matching with AND conditions
//		LogicalExpression andExp = Restrictions.and(fees, name);
//		cr1.add(andExp);

//		cr1.setFirstResult(0);
//		cr1.setMaxResults(4);

		// To get total row count.
		// cr.setProjection(Projections.rowCount());

		// To get average of a property.
		// cr.setProjection(Projections.avg("fees"));

		// To get distinct count of a property.
		cr.setProjection(Projections.countDistinct("name"));

		// To get maximum of a property.
		// cr.setProjection(Projections.max("fees"));

		// To get minimum of a property.
		// cr.setProjection(Projections.min("fees"));

		// To get sum of a property.
		// cr.setProjection(Projections.sum("fees"));
		List resultsCr1 = cr.list();
		System.out.println(resultsCr1);

	}

}
