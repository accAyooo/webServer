package com.webServer.controller;

import com.webServer.common.ServerResponse;
import com.webServer.pojo.User;
import com.webServer.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午11:11 2018/1/24
 */

@Controller
@RequestMapping("/ajax/account")
public class UserAjaxController {

    @Autowired
    private UserService userService;

    /**
     * login
     * @param username
     * @param password
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse login(String username, String password,
            HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        return userService.login(username, password, session);
    }

    /**
     * register
     * @param user
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse register(User user,
               HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        return userService.register(user, session);
    }

    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse userinfo(
                HttpServletRequest request, HttpServletResponse response) {
        return userService.getUserinfo(request);
    }

}
