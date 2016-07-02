package com.kaishengit.dao;

import com.kaishengit.pojo.User;

public class UserDaoImpl2 implements UserDao {
    @Override
    public void save(User user) {
        System.out.println("hi,Spring");
    }

    @Override
    public void sayHi() {
        System.out.println("hi,Spring");
    }

    @Override
    public Integer hh() {
        return 1000;
    }
}
