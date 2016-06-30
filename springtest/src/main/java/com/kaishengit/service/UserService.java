package com.kaishengit.service;

import com.kaishengit.dao.UserDao;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void sayHello(){
        System.out.println("hello,spring");
        userDao.sayHi();
    }
}
