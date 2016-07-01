package com.kaishengit.dao;

import com.kaishengit.pojo.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    void delete(Integer id);
    void update(User user);
    User findById(Integer id);
    List<User> findAll();
    User findByName(String name);
    Long count();
}
