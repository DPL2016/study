package com.kaishengit.test;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTestCase {
    @Test
    public void  loggerTest(){
        String name = "tom";
        String book = "123";
        Logger logger = LoggerFactory.getLogger(LoggerTestCase.class);
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("{}借阅了{}",name,book);
        logger.warn("warn message");
        logger.error("error message");


    }
}
