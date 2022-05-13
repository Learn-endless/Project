package edu.wdu.pojo;

public class Student {
	private int id;
	private String name;
	private String gender;
	private Subject subject;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, String gender, Subject subject) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.subject = subject;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	
}
