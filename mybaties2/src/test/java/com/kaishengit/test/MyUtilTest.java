package com.kaishengit.test;

import com.kaishengit.pojo.Admin;
import com.kaishengit.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

public class MyUtilTest {
    @Test
    public void TestLoadXml(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Admin admin = sqlSession.selectOne("com.kaishengit.mapper.AdminMapper.findById",9);
        sqlSession.close();
        System.out.println(admin);
        Assert.assertNotNull(admin);
    }
}
