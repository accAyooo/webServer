package com.webServer.common.enumeration;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午2:09 2018/1/28
 */
public enum UserRole {

    // 普通用户
    NORMAL_USER(1, "NORMAL_USER"),

    // 工作人员
    STAFF_USER(2, "STAFF_USER"),

    // 管理员
    ADMIN_USER(10, "ADMIN_USER");

    private final int code;
    private final String desc;

    UserRole(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
