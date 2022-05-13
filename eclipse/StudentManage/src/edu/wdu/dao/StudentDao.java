package edu.wdu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import edu.wdu.helper.MySqlHelper;

public class StudentDao {
	
	public static int addStudent(String name,String gender,int subjectId) {
		String sql = "insert into student (name,gender,subject_id) values (?,?,?);";
		return MySqlHelper.executeUpdate(sql,new Object[] {name,gender,subjectId});
	}
	
	public static int updateStudent(int id,String name,String gender,int subjectId) {
		String sql = " update student set name=?,gender=?,subject_id=? where id=?; ";
		return MySqlHelper.executeUpdate(sql,new Object[] {name,gender,subjectId,id});
	}
	
	public static int deleteStudent(int id) {
		String sql = "delete from student where id=?;";
		return MySqlHelper.executeUpdate(sql,new Object[] {id});
	}
	
	public static ArrayList<HashMap<String, Object>> studentList(){
		String sql = "select * from student";
		ArrayList<HashMap<String, Object>> list = MySqlHelper.executeQuery(sql,null);
		for(HashMap<String, Object> student:list) {
			int subjectId = (Integer)student.get("subject_id");
			HashMap<String, Object> subject = SubjectDao.getById(subjectId);
			student.put("subject", subject);
			student.remove("subject_id");
		}
		return list;
	}
	
	
	public static HashMap<String, Object> getById(int id) {
		HashMap<String, Object> student = null;
		String sql = "select * from student where id=?;";
		ArrayList<HashMap<String, Object>> list = MySqlHelper.executeQuery(sql,new Object[] {id});
		if(list !=null && list.size()>0) {
			student = list.get(0);
			int subjectId = (Integer)student.get("subject_id");
			HashMap<String, Object> subject = SubjectDao.getById(subjectId);
			student.put("subject", subject);
			student.remove("subject_id");
		}
		return student;
	}
	
	
}
