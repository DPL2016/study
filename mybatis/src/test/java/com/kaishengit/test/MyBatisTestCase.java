package com.kaishengit.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kaishengit.mapper.AdminMapper;
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
import java.util.Map;

public class MyBatisTestCase {
    private Logger logger = LoggerFactory.getLogger(MyBatisTestCase.class);
    @Test
    public void testLoadXml(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            Admin admin = sqlSession.selectOne("com.kaishengit.mapper.AdminMapper.findById",9);
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
        admin.setName("ming");
        admin.setPassword("123123124");
        admin.setAddress("1112222@qq.com");
        sqlSession.insert("com.kaishengit.mapper.AdminMapper.save",admin);
        sqlSession.commit();
        logger.debug("{}",admin.getId());
        sqlSession.close();
    }

    //Mapper
    @Test
    public void saveMapperTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = new Admin();
        admin.setName("ming");
        admin.setPassword("123123124");
        admin.setAddress("1112222@qq.com");
        mapper.save(admin);
        sqlSession.commit();
        logger.debug("{}",admin.getId());
        sqlSession.close();
    }

    @Test
    public void updateTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Admin admin = sqlSession.selectOne("findById",9);
        admin.setPassword("666666666");
        admin.setAddress("222222222222@qq.com");
        sqlSession.update("com.kaishengit.mapper.AdminMapper.update",admin);
        sqlSession.commit();
        sqlSession.close();
    }

    //mapper
    @Test
    public void updateMapperTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = mapper.findById(9);
        admin.setPassword("666666666");
        admin.setAddress("222222222222@qq.com");
        mapper.update(admin);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteTest(){
       SqlSession sqlSession =  MybatisUtil.getSqlSession();
        sqlSession.delete("com.kaishengit.mapper.AdminMapper.delete",7);
        sqlSession.commit();
        sqlSession.close();
    }

    //mapper
    @Test
    public void deleteMapperTest(){
        SqlSession sqlSession =  MybatisUtil.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        mapper.delete(20);
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
        Assert.assertEquals(9,adminList.size());
    }

    //mapper
    @Test
    public void findAllMapperTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        List<Admin> adminList = adminMapper.findAll();
        sqlSession.close();
        for(Admin admin : adminList){
            System.out.println(admin);
        }
        Assert.assertEquals(9,adminList.size());
    }

    @Test
    public void bathSave(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        List<Admin> adminList = Lists.newArrayList();
        adminList.add(new Admin("n1","m1","c1"));
        adminList.add(new Admin("n2","m2","c2"));
        adminList.add(new Admin("n3","m3","c3"));
        adminList.add(new Admin("n4","m4","c4"));
        adminMapper.bathSave(adminList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findByIds(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        List<Integer> idLists = Lists.newArrayList(3,6,9,20,21);
        List<Admin> adminList = adminMapper.findByIds(idLists);
        for (Admin admin: adminList) {
            System.out.println(admin);
        }
        sqlSession.close();
    }

    @Test
    public void queryByParasTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Map<String,Object>params = Maps.newHashMap();
        params.put("name","lucy");
       // params.put("password",11111);
        params.put("address","1542294533@qq.com");
        Admin admin = adminMapper.queryByParas(params);
        logger.debug("{}",admin);
        Assert.assertNotNull(admin);
    }

}
