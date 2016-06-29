package com.kaishengit.pojo;

import java.io.Serializable;

public class Admin implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private String address;

    public Admin() {
    }

    public Admin(String name, String password, String address) {
        this.name = name;
        this.password = password;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
