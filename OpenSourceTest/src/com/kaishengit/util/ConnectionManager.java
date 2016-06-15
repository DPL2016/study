package com.kaishengit.util;

import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static Logger logger = LoggerFactory.getLogger(ConnectionManager.class);
    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setDriverClassName(Config.get("jdbc.driver"));
        dataSource.setUrl(Config.get("jdbc.url"));
        dataSource.setUsername(Config.get("jdbc.username"));
        dataSource.setPassword(Config.get("jdbc.password"));
        dataSource.setInitialSize(Integer.parseInt(Config.get("jdbc.initsize","5")));
        dataSource.setMaxTotal(Integer.parseInt(Config.get("jdbc.maxtotal","15")));
        dataSource.setMaxWaitMillis(Integer.parseInt(Config.get("jdbc.maxwait","5000")));
        dataSource.setMaxIdle(Integer.parseInt(Config.get("jdbc.maxidle","20")));
        dataSource.setMinIdle(Integer.parseInt(Config.get("jdbc.minidle","10")));
    }

    public static Connection getConnection() throws DataAccessException {

        try {
            Connection connection = dataSource.getConnection();
            logger.debug("数据库连接正常");
            return connection;
        } catch (SQLException e) {
            logger.warn("数据库连接异常");
            throw new DataAccessException("数据库连接异常", e);
        }
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}
