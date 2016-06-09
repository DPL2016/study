package com.kaishengit.test;

import com.kaishengit.dao.AdminDAO;
import com.kaishengit.entity.Admin;
import org.junit.Test;

public class AdminTest {
    AdminDAO dao =new AdminDAO();
    @Test
    public void saveTest(){
        Admin admin = new Admin();
        admin.setName("lili");
        admin.setPassword("12345");
        dao.saveAdmin(admin);
    }
    @Test
    public void deleteTest(){
        dao.deleteAdmin(4);
    }
}
