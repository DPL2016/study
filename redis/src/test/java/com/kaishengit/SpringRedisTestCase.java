package com.kaishengit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringRedisTestCase {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void testSet(){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("Spring","Spring-data");
    }
    @Test
    public void testGet(){
        System.out.println(redisTemplate.opsForValue().get("Spring"));
    }

    @Test
    public void testIncr(){
        redisTemplate.opsForValue().increment("num",2);
        System.out.println(redisTemplate.opsForValue().get("num"));
    }

}
