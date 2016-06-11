package com.kaishengit.test;

import com.kaishengit.entity.User;
import com.kaishengit.exception.DataAccessException;
import com.kaishengit.util.ConnectionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DbUtilsTestUser {
    Connection connection  = ConnectionManager.getConnection();
    @Test
    public void addUser(){
        String sql  = "insert into user(name,password,address) values (?,?,?)";
        QueryRunner queryRunner = new QueryRunner();
        try {
            queryRunner.update(connection,sql,"tom","123","中国");
        } catch (SQLException e) {
            throw new DataAccessException("sql语句"+sql+"异常");
        }finally {
            ConnectionManager.connectionClose(connection);
        }
    }
    @Test
    public  void  removeUser(){
        String sql = "delete from user where id = ?";
        QueryRunner queryRunner = new QueryRunner();
        try {
            queryRunner.update(connection,sql,2);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionManager.connectionClose(connection);
        }
    }
    @Test
    public  void updateUser(){
        String sql = "update user set name=?,password=?,address=? where id = ?";
        QueryRunner queryRunner = new QueryRunner();
        try {
            queryRunner.update(connection,sql,"jam","123456","日本","3");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionManager.connectionClose(connection);
        }
    }
    @Test
    public void  queryUserById(){
        String sql = "select * from user where id =?";
        QueryRunner queryRunner = new QueryRunner();
        try {
            User user = queryRunner.query(connection,sql,new BeanHandler<>(User.class),3);
            Assert.assertNotNull(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionManager.connectionClose(connection);
        }
    }
    @Test
    public void queryAllUser(){
        String sql = "select * from user ";
        QueryRunner queryRunner = new QueryRunner();
        try {
            List<User>list = queryRunner.query(connection,sql,new BeanListHandler<>(User.class));
            Assert.assertEquals(list.size(),2);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionManager.connectionClose(connection);
        }
    }
    @Test
    public void queryUserByIdToMap(){
        String sql = "select*from user where id =?";
        QueryRunner queryRunner = new QueryRunner();
        try {
            Map<String, Object> result = queryRunner.query(connection,sql,new MapHandler(),3);
            Assert.assertNotNull(result);
            for (Map.Entry<String,Object>entry:result.entrySet()){
                System.out.println(entry.getKey()+"->"+entry.getValue());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionManager.connectionClose(connection);
        }
    }
    @Test
    public void queryUserToMapList(){
        String sql = "select * from user";
        QueryRunner queryRunner = new QueryRunner();
        try {
            List<Map<String,Object>>resultList = queryRunner.query(connection,sql,new MapListHandler());
            Assert.assertEquals(resultList.size(),2);
            for (int i=0;i<resultList.size();i++){
                for (Map.Entry<String,Object>entry:resultList.get(i).entrySet()){
                    System.out.println(entry.getKey()+"->"+entry.getValue());

                }
                System.out.println("-----------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionManager.connectionClose(connection);
        }
    }
    @Test
    public void countUser(){
        String sql = "select count(*) from user";
        QueryRunner queryRunner = new QueryRunner();
        try {
            Long count = queryRunner.query(connection,sql,new ScalarHandler<Long>());
            Assert.assertEquals(new Long(2),count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionManager.connectionClose(connection);
        }
    }
    @Test
    public void queryUserName(){
        String sql = "select name from user";
        QueryRunner queryRunner = new QueryRunner();
        try {
            List<String>listName = queryRunner.query(connection,sql,new ColumnListHandler<String>());
            Assert.assertEquals(listName.size(),2);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionManager.connectionClose(connection);
        }
    }
}
