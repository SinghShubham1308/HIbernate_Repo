package com.hibernate.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Lifecycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	}

}
