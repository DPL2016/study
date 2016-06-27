package com.kaishengit.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory = builderSqlSession();

    private static SqlSessionFactory builderSqlSession() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            return sqlSessionFactory;
        } catch (IOException e) {
            throw new RuntimeException("读取xml异常",e);
        }
    }

    public static  SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
