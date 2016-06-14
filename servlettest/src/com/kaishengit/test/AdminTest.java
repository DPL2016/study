package com.kaishengit.test;

import com.kaishengit.dao.AdminDAO;
import com.kaishengit.entity.Admin;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AdminTest {
    AdminDAO dao =new AdminDAO();
    @Test
    public void saveTest(){
        Admin admin = new Admin();
        admin.setName("lucy");
        admin.setPassword("12345");
        dao.saveAdmin(admin);
    }
    @Test
    public void deleteTest(){
        dao.deleteAdmin(4);
    }
    @Test
    public void modifyTest(){
        Admin admin = new Admin();
        admin.setName("jam");
        admin.setPassword("120");
        dao.modifyAdmin(admin,5);
    }
    @Test
    public void queryByIdTest(){
        dao.queryAdminById(5);
    }
    @Test
    public void queryAllTest(){
        List<Admin>list =  dao.queryAll();
        Assert.assertEquals(list.size(),2);
    }

    @Test
    public void findTest(){
        Admin admin = dao.find("tom","123");
        Assert.assertNotNull(admin);
    }

}
