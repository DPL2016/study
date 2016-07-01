package com.kaishengit.service;

import com.kaishengit.dao.UserDao;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserService {

    @Inject
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void sayHello(){
        userDao.sayHi();
    }
}
