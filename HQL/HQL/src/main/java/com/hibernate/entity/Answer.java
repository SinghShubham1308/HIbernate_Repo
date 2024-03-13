package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {

	public Answer() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "AnswerID")
	private int answerId;
	private String answervalue;
//	@OneToOne(mappedBy = "answer")
//	@JoinColumn(name = "QuestionID")
	@ManyToOne
	private Question question;

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswervalue() {
		return answervalue;
	}

	public void setAnswervalue(String answervalue) {
		this.answervalue = answervalue;
	}

	public Answer(int answerId, String answervalue, Question question) {
		super();
		this.answerId = answerId;
		this.answervalue = answervalue;
		this.question = question;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answervalue=" + answervalue +  "]";
	}

}
