package com.kaishengit.mapper;

import com.kaishengit.pojo.User;

public interface UserMapper {
    User findById(Integer id);
    void save(User user);

}
