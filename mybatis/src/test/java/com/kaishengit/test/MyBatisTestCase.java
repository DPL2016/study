package com.kaishengit.test;

import com.kaishengit.pojo.Admin;
import com.kaishengit.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MyBatisTestCase {
    private Logger logger = LoggerFactory.getLogger(MyBatisTestCase.class);
    @Test
    public void testLoadXml(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            Admin admin = sqlSession.selectOne("com.kaishengit.mapper.AdminMapper.findById",7);
            logger.debug("{}",admin);
            sqlSession.close();
            Assert.assertNotNull(admin);
        } catch (IOException e) {
            throw new RuntimeException("加载mybatis.xml文件失败",e);
        }
    }

    @Test
    public void saveTest(){
        /*try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Admin admin = new Admin();
            admin.setName("xiaohei");
            admin.setPassword("123123");
            admin.setAddress("11125541@qq.com");
            sqlSession.insert("com.kaishengit.mapper.AdminMapper.save",admin);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException("加载mybatis.xml异常",e);
        }*/
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Admin admin = new Admin();
        admin.setName("xiaoxiao");
        admin.setPassword("123123");
        admin.setAddress("11125541@qq.com");
        sqlSession.insert("com.kaishengit.mapper.AdminMapper.save",admin);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Admin admin = sqlSession.selectOne("com.kaishengit.mapper.AdminMapper.findById",9);
        admin.setPassword("123456");
        admin.setAddress("147258369@qq.com");
        sqlSession.update("com.kaishengit.mapper.AdminMapper.update",admin);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteTest(){
       SqlSession sqlSession =  MybatisUtil.getSqlSession();
        sqlSession.delete("com.kaishengit.mapper.AdminMapper.delete",8);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findAllTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        List<Admin> adminList = sqlSession.selectList("com.kaishengit.mapper.AdminMapper.findAll");
        sqlSession.close();
        for(Admin admin : adminList){
            System.out.println(admin);
        }
        Assert.assertEquals(4,adminList.size());
    }
}