package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.entity.Student;

public class Pagination {
public static void main(String[] args) {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	Query query = session.createQuery("from Student");
	query.setFirstResult(15);
	query.setMaxResults(50);
	List<Student> list = query.getResultList();
	for(Student student:list) {
		System.out.println("fetching "+ student.getName()+" "+student.getId());
	}
	session.close();
	sessionFactory.close();
}
}
