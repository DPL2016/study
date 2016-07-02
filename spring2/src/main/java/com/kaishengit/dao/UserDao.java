package com.kaishengit.dao;

import com.kaishengit.pojo.User;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
    void save(User user);
    User findById(Integer id);
    List<User> findAll();
    void update(User user);
    Long count();
 }
