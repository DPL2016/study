package com.kaishengit.util;


import com.kaishengit.entity.User;
import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Assert;

import java.sql.Connection;
import java.sql.SQLException;

public class DBHelp2 {
    public static void update(String sql,Object...paras){
        Connection connection = ConnectionManager.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        try {
            queryRunner.update(connection,sql,paras);
        } catch (SQLException e) {
            throw new DataAccessException("sql语句"+sql+"异常");
        }finally {
            ConnectionManager.connectionClose(connection);
        }
    }
    public static <T> T query(String sql, ResultSetHandler<T>handler,Object...paras){
        Connection connection = ConnectionManager.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        try {
            return queryRunner.query(connection,sql,handler,paras);
        } catch (SQLException e) {
            throw new DataAccessException("sql"+sql+"运行异常");
        }finally {
            ConnectionManager.connectionClose(connection);
        }
    }
}
