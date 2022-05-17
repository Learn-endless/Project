package com.donghu.mapper;

import com.donghu.bean.User;

import java.util.List;

public interface UserMapper {
    // 查询所有信息
    List<User> selectAll();
}
