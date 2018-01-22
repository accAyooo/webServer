package com.webServer.controller.ajaxController;

import com.webServer.common.ServerResponse;
import com.webServer.pojo.User;
import com.webServer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/user")
@Controller
public class UserAjaxController {

    @Autowired
    IUserService iUserService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> register(User user) {
        return iUserService.register(user);
    }

}
