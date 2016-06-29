package com.kaishengit.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kaishengit.mapper.AdminMapper;
import com.kaishengit.pojo.Admin;
import com.kaishengit.util.MyBatisUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

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
    //mapper
    public void TestLoadXmlMapper(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
            Admin admin = adminMapper.findById(9);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    //mapper
    @Test
    public void saveMapperTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = new Admin();
        admin.setName("黑");
        admin.setPassword("12345");
        admin.setAddress("U");
        adminMapper.save(admin);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(admin.getId());
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
    public void updateTestMapper(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = adminMapper.findById(9);
        admin.setPassword("123145123");
        admin.setAddress("123789");
        adminMapper.update(admin);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        sqlSession.delete("com.kaishengit.mapper.AdminMapper.delete",31);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteMapperTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        adminMapper.delete(24);
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

    @Test
    public void findAllMapperTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        List<Admin> adminList = adminMapper.findAll();
        for(Admin admin:adminList){
            System.out.println(admin);
        }
        sqlSession.close();
    }

    @Test
    public void findByParam(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Map<String,Object> param = Maps.newHashMap();
        param.put("name","n1");
        param.put("password","n2");
        Admin admin = adminMapper.findByParam(param);
        sqlSession.close();
    }

    @Test
    public void findByParamsTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = adminMapper.findByParams("n1","m1");
    }

    @Test
    public void bathSaveTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        List<Admin> adminList = Lists.newArrayList();
        adminList.add(new Admin("q1","w1","e1"));
        adminList.add(new Admin("q2","w2","e2"));
        adminList.add(new Admin("q3","w3","e3"));
        adminMapper.bathSave(adminList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findbyIdsTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        List<Integer>ids = Lists.newArrayList(3,6,9,13,14,19);
        List<Admin>adminList = adminMapper.findByIds(ids);
        for (Admin admin:adminList){
            System.out.println(admin);
        }
        sqlSession.close();
    }

    @Test
    public void queryByParasTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Map<String,Object>param = Maps.newHashMap();
        param.put("name","q1");
        param.put("password","w1");
        param.put("address","e1");
        Admin admin = adminMapper.queryByParas(param);
        System.out.println(admin);
        sqlSession.close();

    }
}
