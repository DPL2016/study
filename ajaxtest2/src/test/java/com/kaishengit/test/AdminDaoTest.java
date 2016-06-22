package com.kaishengit.test;

import com.kaishengit.dao.AdminDAO;
import com.kaishengit.entity.Admin;
import org.junit.Assert;
import org.junit.Test;

public class AdminDaoTest {
    @Test
    public void test(){
        AdminDAO dao = new AdminDAO();
        Admin admin =  dao.queryAdminByName("tom");
        Assert.assertNotNull(admin);
    }
}
