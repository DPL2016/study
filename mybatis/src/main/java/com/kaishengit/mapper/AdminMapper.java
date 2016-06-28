package com.kaishengit.mapper;

import com.kaishengit.pojo.Admin;

import java.util.List;

public interface AdminMapper {
    Admin findById(Integer id);
    void save(Admin admin);
    void update(Admin admin);
    void delete(Integer id);
    List<Admin> findAll();
}
