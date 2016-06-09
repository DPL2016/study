package com.kaishengit.util;

import com.kaishengit.exception.DataAccessException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static Connection getConnection() throws DataAccessException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql:///db_library","root","root");
                return connection;
            } catch (SQLException e) {
                throw new DataAccessException("数据库连接异常");
            }
        } catch (ClassNotFoundException e) {
           throw new DataAccessException("数据库驱动加载异常");
        }

    }
    public static void connectionClose(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DataAccessException("数据库连接关闭异常");
        }
    }
}
