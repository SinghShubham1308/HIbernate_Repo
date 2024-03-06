package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Address;
import com.hibernate.entity.Student;

public class Getdata {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		
		Student student = session.load(Student.class, 1);
		System.out.println(student);

		Address address = session.get(Address.class, 1);
		System.out.println(address.getState());
		
		session.close();
		sessionFactory.close();
		
	}

	
}
