package com.kaishengit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

public class JedisTestCase {
    private Jedis jedis = null;

    @Before
    public void header(){
        jedis = new Jedis("115.159.159.103");
    }

    @After
    public void footer(){
        if (jedis!=null){
            jedis.close();
        }
    }

    @Test
    public void testSet(){
        Jedis jedis = new Jedis("115.159.159.103");
        jedis.set("Hello","Linux");
        jedis.close();
    }

    @Test
    public void testGet(){
        Jedis jedis = new Jedis("115.159.159.103");
        String str = jedis.get("Hello");
        Assert.assertEquals("Linux",str);
        jedis.close();
    }
    @Test
    public void testIncr(){
        String key = "name:1:num";
        jedis.incr(key);
        System.out.println(jedis.get("name:1:num"));
    }
    @Test
    public void testExists(){
        if (jedis.exists("Hello")){
            System.out.println(jedis.get("Hello"));
        }
    }
    @Test
    public void testIncrby(){
        String key = "num:1:name";
        jedis.incrBy(key,3);
        System.out.println(jedis.get("num:1:name"));
    }

    @Test
    public void testIncrbyFloat(){
        String key = "num:1:float";
        jedis.incrByFloat(key,0.4F);
        System.out.println(jedis.get("num:1:float"));
    }

    @Test
    public void tetsAppend(){
        String key = "Hello";
        jedis.append(key,"Redis");
        System.out.println(jedis.get("Hello"));
    }

    @Test
    public void testMset(){
        jedis.mset("k11","v11","k12","v12");
    }

    @Test
    public void testMget(){
        List<String> lists = jedis.mget("k11","k12");
        for (String str:lists){
            System.out.println(str);
        }
    }




}
