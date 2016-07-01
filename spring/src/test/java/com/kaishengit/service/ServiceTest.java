package com.kaishengit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class ServiceTest {

//    @Test
//    public void testUserService(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        UserService userService = (UserService) context.getBean("userService");
//        userService.sayHello();
//    }


    @Autowired
    private UserService userService;
    @Test
    public void test(){
        userService.sayHello();
    }

}
