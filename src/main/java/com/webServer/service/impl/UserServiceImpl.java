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
        int resultCount = 0;

        resultCount = userMapper.checkByUsername(user.getUsername());

        if (resultCount == 1)
            return ServerResponse.createByErrorMessage("用户名已存在");

        resultCount = userMapper.checkByEmail(user.getEmail());

        if (resultCount == 1)
            return ServerResponse.createByErrorMessage("手机号已经被注册");

        return ServerResponse.createBySuccessMessage("注册成功");

    }
}
