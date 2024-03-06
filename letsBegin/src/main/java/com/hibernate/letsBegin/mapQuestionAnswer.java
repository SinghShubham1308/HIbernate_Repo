package com.hibernate.letsBegin;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Answer;
import com.hibernate.entity.Question;

public class mapQuestionAnswer {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Question question1 = new Question();
		question1.setQuestionID(543);
		question1.setQuestionName("What is Java?");

		Answer answer1 = new Answer(121, "Java is a high-level programming language.", question1);
		Answer answer2 = new Answer(123, "Java is an interpreted language", question1);

		List<Answer> answers = new ArrayList<>();
		answers.add(answer1);
		answers.add(answer2);
		question1.setAnswer(answers);

		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(question1);
			for (Answer answer : answers) {
				session.save(answer);
			}

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		Session session2 = sessionFactory.openSession();
		transaction = null;
		try {
			transaction = session2.beginTransaction();
			Question question = session2.get(Question.class, 543);
			if (question != null) {
				System.out.println("Question ID: " + question.getQuestionID());
				System.out.println("Question Name: " + question.getQuestionName());
				// Fetch and display associated answers
				List<Answer> fetchedAnswers = question.getAnswer();
				System.out.println("Answers:");
				for (Answer fetchedAnswer : fetchedAnswers) {
					System.out.println(" - " + fetchedAnswer.getAnswervalue());
				}
			} else {
				System.out.println("Question with ID 543 not found.");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
