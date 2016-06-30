package com.kaishengit.dao;

public class UserDaoImp1 implements UserDao {
    @Override
    public Integer sayHi() {
        System.out.println("hi,spring");
        return 1000;
    }
}
