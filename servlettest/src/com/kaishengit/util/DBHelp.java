package com.kaishengit.util;

import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import java.sql.SQLException;

public class DBHelp {
    public static void update(String sql,Object...paras){
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());

        try {
            queryRunner.update(sql,paras);
        } catch (SQLException e) {
            throw new DataAccessException("sql语句"+sql+"异常",e);
        }

    }
    public static <T> T query(String sql, ResultSetHandler<T> handler,Object...paras ){
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        try {
           return queryRunner.query(sql,handler,paras);
        } catch (SQLException e) {
            throw new DataAccessException("运行"+sql+"异常",e);
        }
    }
}
