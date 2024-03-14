package com.cascading;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Answer;
import com.hibernate.entity.Question;

public class Cascade {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Question question = new Question();
			question.setQuestionID(123);
			question.setQuestionName("Cascading in Hibernate");

			Answer answer = new Answer(121,
					"Cascading is used to make changes in all tables related to the parent table", question);
			Answer answer2 = new Answer(211, "Persist, All, Delete, Merge", question);
			ArrayList<Answer> list = new ArrayList<>();
			list.add(answer2);
			list.add(answer);
			question.setAnswer(list);

			session.save(question);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace(); // Handle the exception appropriately
		} finally {
			if (session != null) {
				session.close();
			}
			sessionFactory.close();
		}
	}
}
