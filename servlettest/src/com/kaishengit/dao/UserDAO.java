package com.kaishengit.dao;

import com.kaishengit.entity.User;
import com.kaishengit.util.DBHelp;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class UserDAO {
    public void addUser(User user){
        String sql  = "insert into user (name,password,address) values (?,?,?)";
        DBHelp.update(sql,user.getName(),user.getPassword(),user.getAddress());
    }
    public void removeUser(int id){
        String sql = "delete from user where id = ?";
        DBHelp.update(sql,id);
    }
    public void modifyUser(User user,int id){
        String sql = "update user set name =?,password =?,address =? where id =?";
        DBHelp.update(sql,user.getName(),user.getPassword(),user.getAddress(),id);
    }
    public User queryUserById(int id){
        String sql = "select * from user where id =?";
        return DBHelp.query(sql,new BeanHandler<>(User.class),id);
    }
    public List<User> queryAll(){
        String sql = "select * from user ";
        return DBHelp.query(sql,new BeanListHandler<User>(User.class));
    }
}
