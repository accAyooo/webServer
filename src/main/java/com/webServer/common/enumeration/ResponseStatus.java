package com.webServer.common.enumeration;

public enum ResponseStatus {

    SUCCESS(1, "SUCCESS"),
    ERROR(0, "ERROR"),
    NEED_LOGIN(2, "NEED_LOGIN"),
    ARGUMENT_ERROR(10, "ARGUMENT_ERROR");

    private final int code;
    private final String desc;

    ResponseStatus(int code, String desc) {
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
