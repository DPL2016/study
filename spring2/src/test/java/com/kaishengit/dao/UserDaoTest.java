package com.kaishengit.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest {
    @Test
    public void testSave(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao2");
        userDao.sayHi();
    }
}
