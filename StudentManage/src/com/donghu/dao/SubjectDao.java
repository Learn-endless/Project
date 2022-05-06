package com.donghu.dao;

import com.donghu.myhelper.MyHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-05
 * Time: 14:46
 */
public class SubjectDao {
    //新增数据
    public static int insertSubject(String subject_name, int credit){
        String sql = "insert into subject values (null,?,?)";
        return MyHelper.executeUpdate(sql,new Object[]{subject_name,credit});
    }

    //删除课程
    public static int deleteSubject(int id){
        String sql = "delete from subject where subject_id = ?";
        return MyHelper.executeUpdate(sql,new Object[]{id});
    }

    //修改课程信息
    public static int updateSubject(int id,String name,int credit){
        String sql = "update subject set subject_name = ?,subject_credit = ? where subject_id = ?";
        return MyHelper.executeUpdate(sql,new Object[]{name,credit,id});
    }

    //查询课程信息
    public static ArrayList<HashMap<String,Object>> selectSubjectList(){
        String sql = "select * from subject";
        return MyHelper.executeQuery(sql,null);
    }
    //通过课程ID，获取课程对象
    public static HashMap<String,Object> getById(int id){
        String sql = "select * from subject where subject_id = ?";
        ArrayList<HashMap<String, Object>> list = MyHelper.executeQuery(sql, new Object[]{id});

        //用来接收需要的数据
        HashMap<String,Object> result = null;
        if(list != null && list.size() > 0){
            //遍历整个课程列表
            for(HashMap<String,Object> map : list){
                //通过课程ID进行匹配
                if(map.get("subject_id").equals(id)){
                    result = map;
                }
            }
        }
        return result;
    }
}
