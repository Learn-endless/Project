package edu.wdu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import edu.wdu.helper.MySqlHelper;

public class SubjectDao {
	public static int addSubject(String name,int credit) {
		String sql = "insert into subject (name,credit) values (?,?);";
		return MySqlHelper.executeUpdate(sql,new Object[] {name,credit});
	}

	public static int updateSubject(int id,String name,int credit) {
		String sql = " update subject set name=?,credit=? where id=?; ";
		return MySqlHelper.executeUpdate(sql,new Object[] {name,credit,id});
	}
	public static int deleteSubject(int id) {
		String sql = "delete from subject where id=?;";
		return MySqlHelper.executeUpdate(sql,new Object[] {id});
	}

	
	public static ArrayList<HashMap<String, Object>> subjectList() {
		String sql = "select * from subject;";
		return MySqlHelper.executeQuery(sql,null);
	}
	
	public static HashMap<String, Object> getById(int id) {
		HashMap<String, Object> subject = null;
		String sql = "select * from subject where id=?;";
		ArrayList<HashMap<String, Object>> list = MySqlHelper.executeQuery(sql,new Object[] {id});
		if(list !=null && list.size()>0) {
			subject = list.get(0);
		}
		return subject;
	}
}
