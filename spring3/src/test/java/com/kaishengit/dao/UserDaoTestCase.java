package com.kaishengit.dao;

import com.kaishengit.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class UserDaoTestCase {
    @Test
    public void testSave(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        User user = new User();
        user.setName("Jam");
        user.setPassword("147258");
        user.setAddress("HN");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.save(user);
    }

    @Test
    public void testFindById2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        User user = userDao.findById(8);
        System.out.println(user);
        Assert.assertNotNull(user);
    }


    @Test
    public void testFindById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        String sql ="select*from user where id = ?";
        User user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),8);
//        User user = userDao.findById(8);
        System.out.println(user);
        Assert.assertNotNull(user);
    }
}
