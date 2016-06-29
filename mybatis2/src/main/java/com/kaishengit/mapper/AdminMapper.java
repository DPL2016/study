package com.kaishengit.mapper;

import com.kaishengit.pojo.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface AdminMapper {
    @Select("select id,name,password,address from admin where id=#{id}")
    Admin findById(Integer id);

    @Insert("INSERT INTO admin(name, password, address) VALUES (#{name},#{password},#{address});")
    void save(Admin admin);

    @Update("update admin set name=#{name},password=#{password},address=#{address} where id=#{id}")
    void update(Admin admin);

    @Delete("delete from admin where id = #{id}")
    void delete(Integer id);

    @Select("select id,name,password,address from admin")
    List<Admin> findAll();

    @Select("select id,name,password,address from admin where name=#{name} and password=#{password}")
    Admin findByParam(Map<String,Object> param);

    @Select("select id,name,password,address from admin where name=#{name} and password=#{password}")
    Admin findByParams(@Param("name") String name,@Param("password") String password);

    void bathSave(List<Admin> adminList);
    List<Admin> findByIds(List<Integer>ids);
    Admin queryByParas(Map<String,Object>param);
}
