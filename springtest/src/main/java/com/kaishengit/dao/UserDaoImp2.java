package com.kaishengit.dao;

public class UserDaoImp2 implements UserDao {
    @Override
    public Integer sayHi() {
        System.out.println("你好");
        return 100;
    }
}
