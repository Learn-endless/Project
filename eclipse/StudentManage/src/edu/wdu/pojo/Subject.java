package edu.wdu.pojo;

public class Subject {
	private int id;
	private String name;
	//ѧ��
	private int credit;
	public Subject() {
		super();
		// TODO �Զ����ɵĹ��캯�����
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
