package com.qcby.dao;

import com.qcby.enty.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-18
 * Time: 10:23
 */
public interface UserDao {
    //查询所有
    List<User> findAll();
    //通过id查询
    User find(Integer id);
    //添加
    void add(User user);
    //通过id删除
    void del(Integer id);
    //通过id修改
    void update(User user);
}
