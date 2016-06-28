package com.kaishengit.test;

import com.kaishengit.pojo.Admin;
import com.kaishengit.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MyUtilTest {
    @Test
    public void TestLoadXml(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Admin admin = sqlSession.selectOne("com.kaishengit.mapper.AdminMapper.findById",9);
        sqlSession.close();
        System.out.println(admin);
        Assert.assertNotNull(admin);
    }

    @Test
    public void saveTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Admin admin = new Admin();
        admin.setName("小黑");
        admin.setPassword("12345");
        admin.setAddress("Usa");
        sqlSession.insert("com.kaishengit.mapper.AdminMapper.save",admin);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Admin admin = sqlSession.selectOne("com.kaishengit.mapper.AdminMapper.findById",9);
        admin.setPassword("145123");
        admin.setAddress("123");
        sqlSession.update("com.kaishengit.mapper.AdminMapper.update",admin);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        sqlSession.delete("com.kaishengit.mapper.AdminMapper.delete",12);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findAllTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Admin> adminList = sqlSession.selectList("com.kaishengit.mapper.AdminMapper.findAll");
        for (Admin admin :adminList){
            System.out.println(admin);
        }
        sqlSession.close();
    }
}
