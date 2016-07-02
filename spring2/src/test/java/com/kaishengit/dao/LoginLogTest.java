package com.kaishengit.dao;

import com.kaishengit.pojo.LoginLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class LoginLogTest {
    @Inject
    private LoginLogDao loginLogDao;
    @Test
    public void testSave(){
        LoginLog loginLog = new LoginLog();
        loginLog.setIp("192.19.1.41");
        loginLog.setUserid(4);
        loginLogDao.save(loginLog);
    }
}
