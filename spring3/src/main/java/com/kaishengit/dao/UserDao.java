package com.kaishengit.dao;

import com.kaishengit.pojo.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    User findById(Integer id);
    User findByName(String name);
    List<User> findAll();
    Long count();

}
