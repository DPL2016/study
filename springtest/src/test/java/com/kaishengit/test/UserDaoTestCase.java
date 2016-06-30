package com.kaishengit.test;

import com.kaishengit.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTestCase {

    @Test
    public void sayHiTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao2");
        userDao.sayHi();

        UserDao userDao1 = (UserDao) context.getBean("userDao2");
        System.out.println(userDao==userDao1);
    }
}
