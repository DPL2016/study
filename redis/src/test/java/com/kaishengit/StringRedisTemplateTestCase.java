package com.kaishengit;

import com.google.gson.Gson;
import com.kaishengit.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StringRedisTemplateTestCase {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSave(){
        stringRedisTemplate.opsForValue().set("user:1","rose");
    }
    @Test
    public void testSaveSet(){
        stringRedisTemplate.opsForSet().add("user:vote","jack","lisi","zhangsan");
    }
    @Test
    public void testGetFromSet(){
        Set<String> votes = stringRedisTemplate.opsForSet().members("user:vote");
        for (String vote:votes){
            System.out.println(vote);
        }
    }

    @Test
    public void testSetUser(){
        User user = new User(101,"zhangsan",100F);
        stringRedisTemplate.opsForValue().set("user:100",new Gson().toJson(user));
    }
    @Test
    public void testGetUser() {
        String json = stringRedisTemplate.opsForValue().get("user:100");
        User user = new Gson().fromJson(json,User.class);
        System.out.println(user);
    }
}
