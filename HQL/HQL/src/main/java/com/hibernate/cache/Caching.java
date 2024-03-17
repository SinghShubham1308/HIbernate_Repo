package com.hibernate.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class Caching {
	public static void main(String[] args) {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	Student student = session.get(Student.class,1);
	System.out.println(student);
	System.out.println("_______________________________");
	Student student2 = session.get(Student.class,1);
	System.out.println(student2);
	System.out.println(session.contains(student));
	session.close();

	}
}
