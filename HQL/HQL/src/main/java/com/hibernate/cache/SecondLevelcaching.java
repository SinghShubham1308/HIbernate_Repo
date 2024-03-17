package com.hibernate.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class SecondLevelcaching {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Student student = session.get(Student.class, 43);
		System.out.println(student);
		session.close();
		
		System.out.println("________openSession begins______");
		Session openSession = sessionFactory.openSession();
		Student student2 = openSession.get(Student.class, 43);
		System.out.println(student2);
		openSession.close();
	}
}
