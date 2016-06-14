package com.kaishengit.test;

import com.kaishengit.entity.Admin;
import com.kaishengit.service.AdminService;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

public class AdminServiceTest {
    @Test
    public void loginTest(){
        AdminService adminService = new AdminService();
        Admin admin = adminService.login("tom", "123");
        Assert.assertNotNull(admin);
    }
}
