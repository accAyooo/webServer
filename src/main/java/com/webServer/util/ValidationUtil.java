package com.webServer.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    private final static String EMAIL_REG = "[\\w\\.-]+@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
    private final static String MOBILE_REG = "((\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)";
    private final static String PASSWORD_REG = "([\\w`~!@#\\$%\\^&\\*\\(\\)_\\+\\-=\\[\\]\\{\\};:'\",<\\.>/\\?]{6,20})";

    private static boolean mathes(String str ,String reg) {
        if (str == null)
            return false;

        reg = reg.trim();
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        boolean result = m.matches();

        return result;
    }

    public static boolean checkEmail(String email) {
        return mathes(email, EMAIL_REG);
    }

    public static boolean checkMobileNumber(String mobileNum) {
        return mathes(mobileNum, MOBILE_REG);
    }

    public static boolean checkPassword(String password) {
        return mathes(password, PASSWORD_REG);
    }
}
