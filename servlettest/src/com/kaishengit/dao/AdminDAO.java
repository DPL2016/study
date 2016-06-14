package com.kaishengit.dao;

import com.kaishengit.entity.Admin;
import com.kaishengit.util.DBHelp;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class AdminDAO {
    public void saveAdmin(Admin admin){
        String sql ="insert into admin(name,password) values(?,?)";
        DBHelp.update(sql,admin.getName(),admin.getPassword());
    }
    public void deleteAdmin(int id){
        String sql = "delete from admin where id = ?";
        DBHelp.update(sql,id);
    }
    public void modifyAdmin(Admin admin,int id){
        String sql ="update admin set name=?,password=? where id = ?";
        DBHelp.update(sql,admin.getName(),admin.getPassword(),id);
    }
    public Admin queryAdminById(int id){
        String sql = "select * from admin where id = ?";
        return DBHelp.query(sql,new BeanHandler<>(Admin.class),id);
    }
    public List<Admin> queryAll(){
        String sql = "select*from admin";
        return DBHelp.query(sql,new BeanListHandler<>(Admin.class));
    }
    public Admin find(String name,String password){
        String sql = "select*from admin where name=? and password=?";
        return DBHelp.query(sql,new BeanHandler<>(Admin.class),name,password);
    }

}
