package com.kaishengit.test;

import org.apache.log4j.Logger;
import org.junit.Test;

public class LoggerTestCase {
    @Test
    public void  loggerTest(){
        Logger logger = Logger.getLogger(LoggerTestCase.class);
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
        logger.fatal("fatal message");


    }
}
