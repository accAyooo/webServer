package com.webServer.controller.pageController;

import com.google.code.kaptcha.Producer;
import com.webServer.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping("/accounts")
public class UserController {

    @Autowired(required = false)
    Producer captchaProducer = null;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(HttpServletRequest request, HttpServletResponse response) throws Exception {


        return "register";
    }

    @RequestMapping(value = "/Kaptcha.jpg", method = RequestMethod.GET)
    public String KaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {

//        UserValidator.createAuthCodeImage(request, response);
        HttpSession session = request.getSession();

        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        String codeString = captchaProducer.createText();
        System.out.println(codeString);
        session.setAttribute(Constants.AUTH_CODE_NAME, codeString);

        BufferedImage bi = captchaProducer.createImage(codeString);

        ServletOutputStream out = response.getOutputStream();

        ImageIO.write(bi, "jpg", out);

        try{
            out.flush();
        } finally {
            out.close();
        }

        return "null";
    }
}
