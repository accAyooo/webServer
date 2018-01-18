package com.webServer.util;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.awt.image.BufferedImage;

public class AuthCode {
    @Autowired
    private static Producer captchaProducer = null;

    public static void createAuthCodeImage(HttpServletRequest request, HttpServletResponse response)
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
    }
}
