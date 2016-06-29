package com.kaishengit.mapper;

import com.kaishengit.pojo.User;

import java.util.Map;

public interface UserMapper {
    User findById(Integer id);
    void save(User user);
    User findByParam(Map<String,Object>param);
}
