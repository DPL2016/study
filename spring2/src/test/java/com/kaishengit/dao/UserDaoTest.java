package com.kaishengit.dao;

import com.kaishengit.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class UserDaoTest {
    @Inject
    private UserDao userDao;
    @Test
    public void testSave(){
        User user = new User();
        user.setName("tom");
        user.setPassword("1472589633");
        user.setAddress("HK");
        userDao.save(user);
    }

    @Test
    public void testFindById(){
        User user = userDao.findById(4);
        Assert.assertNotNull(user);
    }

    @Test
    public void testFindAll(){
        List<User> userList = userDao.findAll();
        for(User user:userList){
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate(){
        User user = userDao.findById(7);
        user.setPassword("123456");
        user.setAddress("TW");
        userDao.update(user);
    }

    @Test
    public void testCount(){
        Long count = userDao.count();
        System.out.println(count);
    }
}
