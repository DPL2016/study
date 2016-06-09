package com.kaishengit.dao;

import com.kaishengit.entity.Admin;
import com.kaishengit.util.DBHelp;
public class AdminDAO {
    public void saveAdmin(Admin admin){
        String sql ="insert into admin(name,password) values(?,?)";
        DBHelp.update(sql,admin.getName(),admin.getPassword());
    }
    public void deleteAdmin(int id){
        String sql = "delete from admin where id = ?";
        DBHelp.update(sql,id);
    }
}
