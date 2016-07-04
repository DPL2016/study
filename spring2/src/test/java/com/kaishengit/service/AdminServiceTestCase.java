package com.kaishengit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.html.HTMLHeadElement;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class AdminServiceTestCase {
    @Inject
    private AdminService adminService;
    @Test
    public void testAdminService(){
        if (adminService.login("lucy","11111")){
            System.out.println("1111111111111111");
        }
    }
}
