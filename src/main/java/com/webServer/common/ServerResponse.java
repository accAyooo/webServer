package com.webServer.common;

import com.webServer.common.enumeration.ResponseStatus;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    private ServerResponse(int code) {
        this.code = code;
    }

    private ServerResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private ServerResponse(int code, T data) {
        this.code = code;
        this.data= data;
    }

    private ServerResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return code == ResponseStatus.SUCCESS.getCode();
    }

    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<T>(ResponseStatus.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String message) {
        return new ServerResponse<T>(ResponseStatus.SUCCESS.getCode(), message);
    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<T>(ResponseStatus.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse<T> createBySuccess(String message, T data) {
        return new ServerResponse<T>(ResponseStatus.SUCCESS.getCode(), message, data);
    }

    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<T>(ResponseStatus.ERROR.getCode(), ResponseStatus.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String message) {
        return new ServerResponse<T>(ResponseStatus.ERROR.getCode(), message);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int code, String message) {
        return new ServerResponse<T>(code, message);
    }
}
