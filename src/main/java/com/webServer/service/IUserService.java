package com.webServer.service;

import com.webServer.common.ServerResponse;
import com.webServer.pojo.User;

public interface IUserService {
    public ServerResponse<String> register(User user);
}
