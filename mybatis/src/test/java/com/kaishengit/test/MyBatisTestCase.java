package com.kaishengit.test;

import com.kaishengit.pojo.Admin;
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
}
