package com.kaishengit.test;

import com.google.common.collect.Maps;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.User;
import com.kaishengit.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

public class UserTestCase {
    @Test
    public void testFindById(){
        /*try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",13);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(4);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testSave(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("James");
        user.setPassword("123123");
        user.setState("正常");
        user.setEmail("james@google.com");
        user.setCreatetime("2016-06-27 12:23:34");
        userMapper.save(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindByParam(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> param = Maps.newHashMap();
        param.put("username","Rose");
        param.put("password","123123");
        User user = userMapper.findByParam(param);
        System.out.println(user);
        sqlSession.close();
    }
}
