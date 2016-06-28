package com.kaishengit.test;

import com.google.common.collect.Maps;
import com.kaishengit.mapper.AdminMapper;
import com.kaishengit.pojo.Admin;
import com.kaishengit.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Map;

public class MybatisInterfaceTestCase {
    @Test
    public void testInterface(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
//        Map<String,Object> queryParam = Maps.newHashMap();
//        queryParam.put("password","11111");
//        queryParam.put("address","1542294533@qq.com");
//        Admin admin =  adminMapper.findByQueryParam(queryParam);

        Admin admin = adminMapper.findByParams("11111","1542294533@qq.com");
        System.out.println(admin);
        sqlSession.close();
    }
}
