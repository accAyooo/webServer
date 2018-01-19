package com.webServer.controller.pageController;

import com.google.code.kaptcha.Producer;
import com.webServer.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping("/account")
public class accountController {

    @Autowired(required = false)
    private Producer captchaProducer = null;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {

        return "login";
    }

    @RequestMapping("/validation")
    public Object validation(String code, HttpServletRequest request , HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();

        String codeInSession = (String)session.getAttribute(Constants.AUTH_CODE_NAME);

        boolean b = codeInSession.equals(code);

        model.addAttribute("right", b);

        return "validation";
    }

    @RequestMapping("/authcode.jpg")
    public String authCode(HttpServletRequest request, HttpServletResponse response)
    throws Exception{
        HttpSession session = request.getSession();

        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        String codeString = captchaProducer.createText();
        session.setAttribute(com.webServer.common.Constants.AUTH_CODE_NAME, codeString);

        BufferedImage bi = captchaProducer.createImage(codeString);

        ServletOutputStream out = response.getOutputStream();

        ImageIO.write(bi, "jpg", out);

        try{
            out.flush();
        } finally {
            out.close();
        }

        return null;
    }

}
