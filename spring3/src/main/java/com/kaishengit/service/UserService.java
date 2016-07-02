package com.kaishengit.service;

import com.kaishengit.dao.UserDao;

public class UserService {
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }


    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void say(){
        userDao.say();
        System.out.println("你好");
    }
}
