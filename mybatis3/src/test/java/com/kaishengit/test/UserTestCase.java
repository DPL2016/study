package com.kaishengit.test;

import com.kaishengit.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

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
        sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",13);
        sqlSession.close();
    }
}
