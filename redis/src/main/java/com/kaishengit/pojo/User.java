package com.kaishengit.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -5665093258874747215L;
    private Integer id;
    private String username;
    private Float money;

    public User() {
    }

    public User(Integer id, String username, Float money) {
        this.id = id;
        this.username = username;
        this.money = money;
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
        this.username = username;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", money=" + money +
                '}';
    }
}
