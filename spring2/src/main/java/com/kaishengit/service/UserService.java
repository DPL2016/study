package com.kaishengit.service;

import com.kaishengit.dao.UserDao;

public class UserService {
    private UserDao userDao;

    /*public UserService(UserDao userDao,String name) {
        this.userDao = userDao;
        System.out.println(name);
    }*/

    //    set注入
        public void setUserDao(UserDao userDao) {
            this.userDao = userDao;
        }
    public void say(){
        userDao.sayHi();
        System.out.println("您好");
    }
}
