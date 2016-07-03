package com.kaishengit.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -8989343761103655295L;
    private String name;
    private String password;
    private String address;

    public User(String name, String password, String address) {
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
