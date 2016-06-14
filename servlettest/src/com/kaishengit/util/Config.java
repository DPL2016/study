package com.kaishengit.util;

import com.kaishengit.exception.DataAccessException;

import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties properties = new Properties();
    static {
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));

        } catch (IOException e) {
            throw new DataAccessException("读取config.properties异常");
        }
    }
    public static String get(String key){
        return properties.getProperty(key);
    }
    public static String get(String key,String defultValue){
        return properties.getProperty(key);
    }
}
