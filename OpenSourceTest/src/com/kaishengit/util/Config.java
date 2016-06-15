package com.kaishengit.util;

import com.kaishengit.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties properties = new Properties();
    private static Logger logger = LoggerFactory.getLogger(Config.class);
    static {
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
            logger.debug("加载config.properties文件成功");
        } catch (IOException e) {
            logger.debug("加载config.properties文件失败");
            throw new DataAccessException("加载config.properties文件失败", e);
        }
    }
    public static String get(String key){
        return properties.getProperty(key);
    }
    public static String get(String key,String defultValue ){
        return properties.getProperty(key,defultValue);
    }
}
