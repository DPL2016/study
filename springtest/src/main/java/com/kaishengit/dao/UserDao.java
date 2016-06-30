package com.kaishengit.dao;

public class UserDao {
    public void sayHi(){
        System.out.println("hello,Spring");
    }

    public void init() {
        System.out.println("初始化");
    }

    public void destory() {
        System.out.println("销毁");
    }

    public UserDao() {
        System.out.println("创建新对象");
    }

}
