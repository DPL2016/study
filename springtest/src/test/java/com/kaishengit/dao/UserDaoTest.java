package com.kaishengit.dao;

import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class UserDaoTest {

    @Inject
    private UserMapper userMapper;

    @Test
    public void testSave(){
        User user = new User();
        user.setName("Lucy");
        user.setPassword("111111");
        user.setAddress("HK");
        userMapper.save(user);
    }

    @Test
    public void testFindById(){
        userMapper.findById(6);
    }
}
