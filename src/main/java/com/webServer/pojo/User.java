package com.webServer.pojo;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private Integer role;

    private Boolean staff;

    private Integer mark;

    private Date lastActiveTime;

    private String iconUrlSmall;

    private String iconUrlNormal;

    private Date createTime;

    private Date updateTime;

    public User(Integer id, String username, String password, String email, Integer role, Boolean staff, Integer mark, Date lastActiveTime, String iconUrlSmall, String iconUrlNormal, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.staff = staff;
        this.mark = mark;
        this.lastActiveTime = lastActiveTime;
        this.iconUrlSmall = iconUrlSmall;
        this.iconUrlNormal = iconUrlNormal;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Boolean getStaff() {
        return staff;
    }

    public void setStaff(Boolean staff) {
        this.staff = staff;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Date getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(Date lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

    public String getIconUrlSmall() {
        return iconUrlSmall;
    }

    public void setIconUrlSmall(String iconUrlSmall) {
        this.iconUrlSmall = iconUrlSmall == null ? null : iconUrlSmall.trim();
    }

    public String getIconUrlNormal() {
        return iconUrlNormal;
    }

    public void setIconUrlNormal(String iconUrlNormal) {
        this.iconUrlNormal = iconUrlNormal == null ? null : iconUrlNormal.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}