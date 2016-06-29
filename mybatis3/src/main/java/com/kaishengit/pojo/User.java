package com.kaishengit.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -271559186475348240L;
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private String createtime;
    private String loginip;
    private String logintime;
    private String state;

    public User() {
    }

    public User(Integer id, String username, String password, String email, String avatar, String createtime, String loginip, String logintime, String state) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.createtime = createtime;
        this.loginip = loginip;
        this.logintime = logintime;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getCreatetime() {
        return createtime;
    }

    public String getLoginip() {
        return loginip;
    }

    public String getLogintime() {
        return logintime;
    }

    public String getState() {
        return state;
    }
}
