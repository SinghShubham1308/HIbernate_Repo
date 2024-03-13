package com.hibernate.HQL.start;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String queryString = "from Student where course =:x  and name=:n";
		Query q = session.createQuery(queryString, Student.class);
		q.setParameter("x", "hibernate");
		q.setParameter("n", "Shubham");
		List<Student> list = q.getResultList();
		System.out.print(list.size());
		for (Student student : list) {
			System.out.println(student.getName());
		}
		System.out.println("---------------------------------------------");
//		TypedQuery<Student> query = session.createQuery("delete from Student where name =:x");
//		query.setParameter("x", "abc");
//		int r = query.executeUpdate();
//		System.out.println("No. of deleted entries"+r);
		System.out.println("----------------------------------------------");
		TypedQuery<Student> query1 = session.createQuery("update  Student set name =:c where course =:p");
		query1.setParameter("c", "abhishek");
		query1.setParameter("p", "hibernate");
		int t = query1.executeUpdate();
		System.out.println("No. of updated entries"+t);
		transaction.commit();
		session.clear();
		sessionFactory.close();
	}
}
