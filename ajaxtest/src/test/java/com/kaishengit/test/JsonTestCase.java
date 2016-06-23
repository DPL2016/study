package com.kaishengit.test;

import com.google.gson.Gson;
import com.kaishengit.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTestCase {
    @Test
    public void testToObject(){
        User user = new User(1,"小明","中国",89F);
        Gson gson = new Gson();
        String json = gson.toJson(user);
        System.out.println(json);
    }

    @Test
    public void testMapToObject(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",12);
        map.put("message","今天下雨");
        String json = new Gson().toJson(map);
        System.out.println(json);
    }

    @Test
    public void testArrayToObject(){
        String[] names = {"tom","jam","jack"};
        String json = new Gson().toJson(names);
        System.out.println(json);
    }

    @Test
    public void testObjectArrayToJson(){
        User[] users = new User[3];
        users[0] = new User(1,"tom","usa",77.1F);
        users[1] = new User(11,"jam","usa",56.1F);
        users[2] = new User(111,"小明","中国",100F);
        String json = new Gson().toJson(users);
        System.out.println(json);
    }

    @Test
    public void  testListToJson(){
        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"tom","usa",77.1F));
        userList.add(new User(11,"jam","usa",56.1F));
        userList.add(new User(111,"小明","中国",100F));
        String json = new Gson().toJson(userList);
        System.out.println(json);
    }

    @Test
    public  void  testOtherToJson(){
        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"tom","usa",77.1F));
        userList.add(new User(11,"jam","usa",56.1F));
        userList.add(new User(111,"小明","中国",100F));
        Map<String,Object> map = new HashMap<>();
        map.put("name","add");
        map.put("userlist",userList);
        String json = new Gson().toJson(map);
        System.out.println(json);
    }
}
