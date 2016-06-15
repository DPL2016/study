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
        Properties properties = new Properties();
        try {
            properties.load(ConnectionManager.class.getClassLoader().getResourceAsStream("config.properties"));
            logger.debug("加载config.properties文件成功");
        } catch (IOException e) {
            logger.debug("加载config.properties文件失败");
            throw new DataAccessException("加载config.properties文件失败", e);
        }
        dataSource.setDriverClassName(properties.getProperty("jdbc.driver"));
        dataSource.setUrl(properties.getProperty("jdbc.url"));
        dataSource.setUsername(properties.getProperty("jdbc.username"));
        dataSource.setPassword(properties.getProperty("jdbc.password"));
        dataSource.setInitialSize(Integer.parseInt(properties.getProperty("jdbc.initsize","5")));
        dataSource.setMaxTotal(Integer.parseInt(properties.getProperty("jdbc.maxtotal","15")));
        dataSource.setMaxWaitMillis(Integer.parseInt(properties.getProperty("jdbc.maxwait","5000")));
        dataSource.setMaxIdle(Integer.parseInt(properties.getProperty("jdbc.maxidle","20")));
        dataSource.setMinIdle(Integer.parseInt(properties.getProperty("jdbc.minidle","10")));
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
