package com.kaishengit.util;

import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        Properties prop = new Properties();
        try {
            prop.load(ConnectionManager.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new DataAccessException("读取config.propreties异常", e);

        }
        dataSource.setDriverClassName(prop.getProperty("jdbc.driver"));
        dataSource.setUrl(prop.getProperty("jdbc.url"));
        dataSource.setUsername(prop.getProperty("jdbc.username"));
        dataSource.setPassword(prop.getProperty("jdbc.password"));

        dataSource.setInitialSize(Integer.parseInt(prop.getProperty("jdbc.initsize", "5")));
        dataSource.setMaxTotal(Integer.parseInt(prop.getProperty("jdbc.maxsize", "15")));
        dataSource.setMaxWaitMillis(Integer.parseInt(prop.getProperty("jdbc.maxwait", "5000")));
        dataSource.setMaxIdle(Integer.parseInt(prop.getProperty("jdbc.maxidle", "20")));
        dataSource.setMinIdle(Integer.parseInt(prop.getProperty("jdbc.minidle", "10")));
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() throws DataAccessException {

        try {
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            throw new DataAccessException("数据库连接异常");
        }

    }

    public static void connectionClose(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DataAccessException("数据库连接关闭异常");
        }
    }
}
