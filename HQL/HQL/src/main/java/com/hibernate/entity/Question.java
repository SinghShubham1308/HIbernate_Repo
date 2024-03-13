package com.hibernate.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	// TODO Auto-generated constructor stub
	@Id
	@Column(name = "QuestionId")
	private int questionID;
	private String questionName;

//	@OneToOne(targetEntity = Answer.class)
//	@JoinColumn(name = "answerID")
	@OneToMany(mappedBy = "question")
	private List<Answer> answer;

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public Question(int questionID, String questionName, List<Answer> answer) {
		super();
		this.questionID = questionID;
		this.questionName = questionName;
		this.answer = answer;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", questionName=" + questionName + ", answer=" + answer + "]";
	}

}
