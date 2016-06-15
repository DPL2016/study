package com.kaishengit.test;

import com.kaishengit.dao.AdminDao;
import com.kaishengit.entity.Admin;
import com.kaishengit.service.AdminService;
import org.junit.Assert;
import org.junit.Test;

public class AdminDaoTest {
    Admin admin = new Admin();
    AdminDao dao = new AdminDao();

    @Test
    public void testAddAdmin() {
        admin.setName("xiao");
        admin.setPassword("456");
        admin.setAddress("1542294533@qq.com");
        dao.addAdmin(admin);
    }

    @Test
    public void removeAdminTest() {
        dao.removeAdminById(5);
    }

    @Test
    public void modifyAdminTest() {
        admin.setName("lucy");
        admin.setPassword("11111");
        admin.setAddress("1542294533@qq.com");
        dao.modifyAdmin(admin, 6);
    }

    @Test
    public void queryAdminByIdTest() {
        Admin admin = dao.queryAdminById(6);
        Assert.assertNotNull(admin);
    }

    @Test
    public void AdminServiceTest(){
        AdminService adminService = new AdminService();
       Admin admin =  adminService.login("lucy","11111");
        Assert.assertNotNull(admin);
    }
}

