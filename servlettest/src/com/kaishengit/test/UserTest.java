package com.kaishengit.test;

import com.kaishengit.dao.UserDAO;
import com.kaishengit.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserTest {
    User user = new User();
    UserDAO dao = new UserDAO();
    @Test
    public void addTest(){
        user.setName("tom");
        user.setPassword("120");
        user.setAddress("美国");
        dao.addUser(user);
    }
    @Test
    public void removeTest(){
        dao.removeUser(3);
    }
    @Test
    public void modifyTest(){
        user.setName("tom");
        user.setPassword("110");
        user.setAddress("美国");
        dao.modifyUser(user,4);
    }
    @Test
    public void  queryOneTest(){
       User user =  dao.queryUserById(4);
        System.out.println(dao.queryUserById(4));
    }
    @Test
    public void queryAllTest(){
        List<User>list = dao.queryAll();
        Assert.assertEquals(list.size(),2);
    }
}
