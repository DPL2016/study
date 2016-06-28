package com.kaishengit.mapper;

import com.kaishengit.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminMapper {
    Admin findById(Integer id);
    void save(Admin admin);
    void update(Admin admin);
    void delete(Integer id);
    List<Admin> findAll();
    Admin findByQueryParam(Map<String,Object> params);
    Admin findByParams(@Param("password") String password, @Param("address") String address);
    void bathSave(List<Admin> adminList);
    List<Admin> findByIds(List<Integer> idList);
}
