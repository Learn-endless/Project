package edu.wdu.pojo;

public class Subject {
	private int id;
	private String name;
	//学分
	private int credit;
	public Subject() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Subject(int id, String name, int credit) {
		super();
		this.id = id;
		this.name = name;
		this.credit = credit;
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
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
}
