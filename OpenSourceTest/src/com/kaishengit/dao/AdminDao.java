package com.kaishengit.dao;

import com.kaishengit.entity.Admin;
import com.kaishengit.util.DBHelp;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class AdminDao {
    public void addAdmin(Admin admin){
        String sql = "insert into admin(name,password,address) values (?,?,?)";
        DBHelp.update(sql,admin.getName(),admin.getPassword(),admin.getAddress());
    }
    public void removeAdminById(int id){
        String sql = "delete from admin where id =?";
        DBHelp.update(sql,id);
    }
    public void modifyAdmin(Admin admin,int id){
        String sql = "update admin set name=?,password=?,address=? where id =?";
        DBHelp.update(sql,admin.getName(),admin.getPassword(),admin.getAddress(),id);
    }
    public Admin queryAdminById(int id){
        String sql = "select*from admin where id =?";
        return DBHelp.query(sql,new BeanHandler<>(Admin.class),id);
    }
    public Admin queryAdminByName(String name){
        String sql = "select*from admin where name =?";
        return DBHelp.query(sql,new BeanHandler<>(Admin.class),name);
    }
}
