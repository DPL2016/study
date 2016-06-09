package com.kaishengit.util;

import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class DBHelp {
    public static void update(String sql,Object...paras){
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnectionManager.getConnection();
        try {
            queryRunner.update(connection,sql,paras);
        } catch (SQLException e) {
            throw new DataAccessException("sql语句"+sql+"异常");
        }finally {
            ConnectionManager.connectionClose(connection);
        }
    }
}
