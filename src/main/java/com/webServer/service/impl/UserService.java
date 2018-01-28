package com.webServer.service.impl;

import com.webServer.common.Constants;
import com.webServer.common.CookieArray;
import com.webServer.common.enumeration.UserRole;
import com.webServer.util.EncryptUtil;
import com.webServer.common.ServerResponse;
import com.webServer.dao.UserMapper;
import com.webServer.pojo.User;
import com.webServer.service.IUserService;
import com.webServer.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午11:17 2018/1/24
 */

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password, HttpSession session) {

        // 校验是否已经登陆
        User user = null;
        user = (User)session.getAttribute(Constants.USER_IN_SESSION_NAME);
        if (user != null) {
            return ServerResponse.createBySuccessMessage("登陆成功");
        }

        // 校验用户名是否存在
        int resultCount = 0;
        resultCount = userMapper.checkUsername(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("用户名或密码错误");
        }

        // md5 encrypt
        password = EncryptUtil.Password2Md5(password);

        user = userMapper.selectLogin(username, password);

        // 校验密码
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户名或密码错误");
        }

        session.setAttribute(Constants.USER_IN_SESSION_NAME, user);
        return ServerResponse.createBySuccessMessage("登陆成功");
    }

    @Override
    public ServerResponse<String> register(User user, HttpSession session) {

        // 校验邮箱是否合法
        if (!ValidationUtil.checkEmail(user.getEmail())) {
            return ServerResponse.createByErrorMessage("邮箱不合法");
        }

        // check if email has exist
        int resultCount = userMapper.checkEmail(user.getEmail());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("邮箱已存在");
        }

        resultCount = userMapper.checkUsername(user.getUsername());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("用户名已存在");
        }

        String pwd = user.getPassword();

        // 校验密码是否为空
        if (org.apache.commons.lang3.StringUtils.isEmpty(pwd)) {
            return ServerResponse.createByErrorMessage("密码不能为空");
        }

        // 校验密码是否合法
        if (!ValidationUtil.checkPassword(pwd)) {
            return ServerResponse.createByErrorMessage("密码不合法");
        }

        // md5 password
        pwd = EncryptUtil.Password2Md5(pwd);
        if (pwd == null) {
            return ServerResponse.createByError();
        }
        user.setPassword(pwd);

        // 初始化用户权限
        user.setRole(UserRole.NORMAL_USER.getCode());
        user.setStaff(false);

        // 更新activeTime
        Date date = new Date(new java.util.Date().getTime());
        user.setLastActiveTime(date);

        // 校验通过 存入数据库
        int resultRow = 0;
        resultRow = userMapper.insert(user);

        if (resultRow == 0) {
            return ServerResponse.createByErrorMessage("创建用户失败");
        }

        session.setAttribute(Constants.USER_IN_SESSION_NAME, user);
        return ServerResponse.createBySuccessMessage("创建成功");
    }

    @Override
    public int checkEmail(String email) {
        return userMapper.checkEmail(email);
    }

    @Override
    public ServerResponse getUserinfo(HttpServletRequest request) {

        // 获取用户cookie
        CookieArray cookies = new CookieArray(request.getCookies());
        Cookie cookie = cookies.getCookieByKey(Constants.cookieName.USER_ID);

        // 校验cookie可用性
        if (cookie == null) {
            return ServerResponse.createByErrorMessage("用户未登陆");
        }

        User user = null;
        user = userMapper.selectByPrimaryKey(Integer.parseInt(cookie.getValue()));

        // 校验cookie是否正确　
        if (user == null) {
            return ServerResponse.createByError();
        }

        return ServerResponse.createBySuccess(user);
    }
}
