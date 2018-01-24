package com.webServer.dao;

import com.webServer.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkEmail(String email);

    int checkUsername(String username);

    User selectLogin(@Param(value = "username")String username, @Param(value = "password")String password);
}