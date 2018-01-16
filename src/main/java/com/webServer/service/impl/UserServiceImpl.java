package com.webServer.service.impl;

import com.webServer.common.ServerResponse;
import com.webServer.dao.UserMapper;
import com.webServer.pojo.User;
import com.webServer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<String> register(User user) {
        System.out.println(user.getPhoneNum());
        System.out.println(userMapper.checkByPhone(user.getPhoneNum()));

        return null;
    }
}
