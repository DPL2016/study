package com.kaishengit.test;

import com.kaishengit.entity.Admin;
import com.kaishengit.util.ConnectionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DbUtilsTestCase {
    Connection connection = ConnectionManager.getConnection();
    @Test
    public void add(){
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into admin(name,password) values (?,?)";
        try {
            queryRunner.update(connection,sql,"lucy","123145");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void remove(){
         QueryRunner queryRunner = new QueryRunner();
        String sql = "delete from admin where id = ?";
        try {
            queryRunner.update(connection,sql,2);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void modify(){
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update admin set name='xiaoming' where id = ?";
        try {
            queryRunner.update(connection,sql,4);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testQueryById(){
        String sql = "select * from admin where id = ?";
        QueryRunner queryRunner = new QueryRunner();
        try {
            Admin admin = queryRunner.query(connection,sql,new BeanHandler<>(Admin.class),4);
            System.out.println(admin);
            Assert.assertNotNull(admin);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void queryAll(){
        String sql = "select * from admin ";
        QueryRunner queryRunner  = new QueryRunner();
        try {
            List<Admin> admins = queryRunner.query(connection,sql,new BeanListHandler<>(Admin.class));
            System.out.println(admins);
            Assert.assertNotNull(admins);
            Assert.assertEquals(admins.size(),2);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testQueryByIdToMap(){
        String sql = "select *from admin where id =?";
        QueryRunner queryRunner = new QueryRunner();
        try {
            Map<String,Object> result = queryRunner.query(connection,sql,new MapHandler(),4);
            for (Map.Entry<String,Object> entry:result.entrySet() ){
                System.out.println(entry.getKey()+"->"+entry.getValue());
            }
            Assert.assertNotNull(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testQueryToMapList(){
        String sql = "select * from admin  ";
        QueryRunner queryRunner = new QueryRunner();
        try {
            List<Map<String,Object>> resultList = queryRunner.query(connection,sql,new MapListHandler());
            for (int i=0;i<resultList.size();i++){
                Map<String,Object> result = resultList.get(i);
                for (Map.Entry<String,Object>entry:result.entrySet()){
                    System.out.println(entry.getKey()+"->"+entry.getValue());
                }
                System.out.println("--------------------");
            }
            Assert.assertEquals(resultList.size(),2);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testCount(){
        String sql = "select count(*) from admin";
        QueryRunner queryRunner = new QueryRunner();
        try {
            Long count = queryRunner.query(connection,sql,new ScalarHandler<Long>());
            Assert.assertEquals(new Long(2),count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testQueryAllName(){
        String sql = "select name from admin ";
        QueryRunner queryRunner = new QueryRunner();
        try {
            List<String> nameList =queryRunner.query(connection,sql,new ColumnListHandler<String>());
            Assert.assertEquals(2,nameList.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
