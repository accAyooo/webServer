package com.webServer.common;

import javax.servlet.http.Cookie;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午4:28 2018/1/28
 */
public class CookieArray {
    private Cookie[] cookies;

    public CookieArray(Cookie[] cookies) {
        this.cookies = cookies;
    }

    public Cookie[] getCookies() {
        return cookies;
    }

    public Cookie getCookieByKey(String key) {
        for (int i = 0; i < cookies.length; i ++) {
            if (cookies[i].getName().equals(key)) {
                return cookies[i];
            }
        }
        return null;
    }
}
