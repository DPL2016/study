package com.kaishengit.util;

import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DBHelp {
    private static Logger logger = LoggerFactory.getLogger(DBHelp.class);
    public static void update(String sql, Object... paras) {
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        try {
            queryRunner.update(sql, paras);
            logger.debug("sql{}运行正常", sql);
        } catch (SQLException e) {
            logger.warn("sql{}运行异常", sql);
            e.printStackTrace();
        }
    }

    public static <T> T query(String sql, ResultSetHandler<T> handler, Object... paras) {
        try {
            QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
            T result = queryRunner.query(sql, handler, paras);
            logger.debug("sql{}运行正常", sql);
            return result;
        } catch (SQLException e) {
            logger.warn("sql{}运行异常", sql);
            throw new DataAccessException("sql运行异常", e);
        }
    }
}
