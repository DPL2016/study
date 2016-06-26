package com.kaishengit.util;

import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class DBHelp {
    private static Logger logger = LoggerFactory.getLogger(DBHelp.class);
    public static boolean update(String sql,Object...paras){
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());

        try {
            logger.debug("sql{}运行正常",sql);
            return queryRunner.update(sql,paras)==1;

        } catch (SQLException e) {
            logger.error("sql{}运行错误",sql);
            throw new DataAccessException("sql语句"+sql+"异常",e);
        }

    }
    public static <T> T query(String sql, ResultSetHandler<T> handler,Object...paras ){
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        try {
            T result = queryRunner.query(sql,handler,paras);
            logger.debug("sql{}运行正常",sql);
           return result;
        } catch (SQLException e) {
            logger.error("sql{}运行错误",sql);
            throw new DataAccessException("运行"+sql+"异常",e);
        }
    }
}
