package com.hibernate.letsBegin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.Address;
import com.hibernate.entity.Certificate;
import com.hibernate.entity.Student;

/**
 * Hello world!
 *
 */

public class App {

	public static void main(String[] args) {

//        Configuration configuration=new Configuration();
//        configuration.configure();
//        SessionFactory sessionFactory=configuration.buildSessionFactory();
//        System.out.println(sessionFactory);
//        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
//        System.out.println(sessionFactory);

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		System.out.println(sessionFactory);
		Student student = new Student();
		student.setId(12);
		student.setName("arjun");
		student.setBranch("CS");
		student.setCourse("B-Tech");
		Address address = new Address();
		address.setCity("Lucknow");
		address.setState("Uttar Pradesh");
		address.setStreetString("jankipuram");
		address.setDate(new Date());
		address.setIsempty(false);
		student.setCertificate(new Certificate("Java","rangana"));
		
		try (FileInputStream fileInputStream = new FileInputStream("src/main/java/unnamed.jpg")) {
			byte[] data = new byte[fileInputStream.available()];
			fileInputStream.read();
			address.setImage(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Session session = sessionFactory.openSession();
    	Transaction transaction=session.beginTransaction();
    	System.out.println(transaction);
		session.save(student);
		session.save(address);

    	transaction.commit();
		session.close();
	}
}
