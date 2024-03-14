package com.SQL;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.hibernate.entity.Student;

public class Nativesql {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		String query = "Select * from Student where id between 10 and 15";
		NativeQuery sqlQuery = session.createSQLQuery(query);
		List<Object[]> list = sqlQuery.getResultList();
		for (Object[] student : list) {
			System.out.println(Arrays.deepToString(student));
		}

		session.close();
		sessionFactory.close();
	}
}
