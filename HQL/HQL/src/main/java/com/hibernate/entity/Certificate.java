package com.hibernate.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {

	public Certificate(String courseString, String instructorString) {
		super();
		this.courseString = courseString;
		this.instructorString = instructorString;
	}

	public String getCourseString() {
		return courseString;
	}

	public void setCourseString(String courseString) {
		this.courseString = courseString;
	}

	public String getInstructorString() {
		return instructorString;
	}

	public void setInstructorString(String instructorString) {
		this.instructorString = instructorString;
	}

	private String courseString;
	private String instructorString;

	public Certificate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Certificate [courseString=" + courseString + ", instructorString=" + instructorString + "]";
	}

}
