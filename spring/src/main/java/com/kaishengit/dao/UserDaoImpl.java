package com.kaishengit.dao;

import javax.inject.Named;

@Named
public class UserDaoImpl implements UserDao {
    @Override
    public void sayHi() {
        System.out.println("hi,Spring");
    }
}
