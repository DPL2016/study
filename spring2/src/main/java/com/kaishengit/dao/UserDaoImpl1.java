package com.kaishengit.dao;

import com.kaishengit.pojo.User;

public class UserDaoImpl1 implements UserDao {
    @Override
    public void save(User user) {
        System.out.println("hello,Spring");
    }

    @Override
    public void sayHi() {
        System.out.println("hello,Spring");
    }

    @Override
    public Integer hh() {
        return 100;
    }
}
