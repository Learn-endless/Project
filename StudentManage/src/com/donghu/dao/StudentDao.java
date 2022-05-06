package com.donghu.dao;

import com.donghu.myhelper.MyHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-06
 * Time: 19:14
 */
public class StudentDao {
    //新增学生
    public static int insertStudent(String name,String gender,int subject_id){
        String sql = "insert into student values (null,?,?,?)";
        return MyHelper.executeUpdate(sql,new Object[]{name,gender,subject_id});
    }

    //删除学生信息
    public static int deleteStudent(int id){
        String sql = "delete from student where student_id = ?";
        return MyHelper.executeUpdate(sql,new Object[]{id});
    }

    //修改学生信息
    public static int updateStudent(int id, String name, String gender,int subjectId){
        String sql = "update student set student_name = ? , student_gender = ? , student_subject = ? where student_id = ?";
        return MyHelper.executeUpdate(sql,new Object[]{name,gender,subjectId,id});
    }

    //查询学生信息
    public static ArrayList<HashMap<String,Object>> selectStudent(){
        String sql = "select * from student,subject where subject_id = student_subject";
        return MyHelper.executeQuery(sql,null);
    }
    //通过学生ID来查询学生信息(学生信息加课程信息)
    public static HashMap<String,Object> getById(int id){
        String sql = "select * from subject,student where subject_id = student_subject and student_id = ?";
        HashMap<String,Object> result = null;
        ArrayList<HashMap<String, Object>> list = MyHelper.executeQuery(sql, new Object[]{id});
        if(list != null && list.size() > 0){
            result = list.get(0);
        }
        return result;
    }
}
