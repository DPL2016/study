package com.kaishengit.service;

import com.kaishengit.dao.LoginLogDao;
import com.kaishengit.dao.UserDao;
import com.kaishengit.pojo.LoginLog;
import com.kaishengit.pojo.User;
import com.kaishengit.util.EmailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Transactional
public class UserService {
    @Inject
    private LoginLogDao loginLogDao;
    @Inject
    private UserDao userDao;
    public User login(String name,String password,String ip){
        User user = userDao.findByName("tom");
        if (user!=null&&user.getPassword().equals(password)){
            loginLogDao.save(new LoginLog(ip,user.getId()));
            EmailUtil.send();
        }
        return user;
    }

}
