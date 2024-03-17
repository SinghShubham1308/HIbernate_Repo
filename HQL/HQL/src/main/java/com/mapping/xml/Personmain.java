package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Personmain {
public static void main(String[] args) {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session openSession = sessionFactory.openSession();
	Transaction beginTransaction = openSession.beginTransaction();
	
	Person person = new Person(12,"Shubham","Singh","4/143 sec-h jankipuram Lucknow","8840045218");
	openSession.save(person);
	beginTransaction.commit();
	openSession.close();
	sessionFactory.close();
	
}
}
