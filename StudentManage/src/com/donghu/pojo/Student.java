package com.donghu.pojo;

public class Student {
	private int student_id;
	private String student_name;
	private String student_gender;
	private Subject student_subject;

	public Student() {
	}

	public Student(int student_id, String student_name, String student_gender, Subject student_subject) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_gender = student_gender;
		this.student_subject = student_subject;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_gender() {
		return student_gender;
	}

	public void setStudent_gender(String student_gender) {
		this.student_gender = student_gender;
	}

	public Subject getStudent_subject() {
		return student_subject;
	}

	public void setStudent_subject(Subject student_subject) {
		this.student_subject = student_subject;
	}
}
