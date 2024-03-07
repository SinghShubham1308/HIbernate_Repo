package com.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Lifecycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		practical of hibernate object state
//		State 1 transient
//		State 2 persistent
//		State 3 detached
//		State 4 removed
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Student student = new Student();
		student.setBranch("IT");
		student.setId(12);
		student.setName("Tom");
		student.setCourse("Btech");
		student.setCertificate(new Certificate("Hibernate","durgesh"));
//		transient state
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(student);
		transaction.commit();
		session.close();
//		persistent state
		
		sessionFactory.close();
	}

}
