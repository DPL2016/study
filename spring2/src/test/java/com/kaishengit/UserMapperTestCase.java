package com.kaishengit;

import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class UserMapperTestCase {
    @Inject
    private UserMapper userMapper;
    @Test
    public void saveTest(){
        User user = new User();
        user.setName("jack");
        user.setPassword("123123");
        user.setAddress("CH");
        userMapper.save(user);
    }

    @Test
    public void findByIdTest(){
        User user = userMapper.findById(4);
        System.out.println(user);
    }
}
