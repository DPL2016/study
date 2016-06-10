package com.kaishengit.dao;

import com.kaishengit.entity.Admin;
import com.kaishengit.exception.DataAccessException;
import com.kaishengit.util.ConnectionManager;
import com.kaishengit.util.DBHelp;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
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
}
