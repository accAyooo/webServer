package com.webServer.service;

import com.webServer.common.ServerResponse;
import com.webServer.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午11:17 2018/1/24
 */
public interface IUserService {

    /**
     * user login service
     * @param user
     * @param session
     * @return
     */
    public ServerResponse<User> login(String username, String password, HttpSession session);

    /**
     * user register service
     * @param user
     * @param session
     * @return
     */
    public ServerResponse<String> register(User user, HttpSession session);

    /**
     * 校验邮箱是否存在
     * @param email
     * @return
     */
    public int checkEmail(String email);


}
