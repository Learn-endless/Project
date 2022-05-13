package edu.wdu.pojo;

public class Result {
	private String flag;
	private Object data;
	
	public Result() {
		super();
	}
	
	public Result(String flag, Object data) {
		super();
		this.flag = flag;
		this.data = data;
	}
	
	public String getFlag() {
		return flag;
	}
	
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
}
