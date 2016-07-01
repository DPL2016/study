package com.kaishengit.service;

import com.kaishengit.dao.LoginLogDao;
import com.kaishengit.dao.UserDao;
import com.kaishengit.exception.UserDaoServiceException;
import com.kaishengit.pojo.LoginLog;
import com.kaishengit.pojo.User;
import com.kaishengit.util.EmailUtil;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Transactional
public class UserService {

    @Inject
    private UserDao userDao;

    @Inject
    private LoginLogDao loginLogDao;

    public User login(String name,String password,String ip){
        User user = userDao.findByName(name);
        if (user!=null&&user.getPassword().equals(password)){
            loginLogDao.save(new LoginLog(ip,user.getId()));
            EmailUtil.send();
            return user;
        }else {
            throw new UserDaoServiceException("用户名或密码错误");
        }

    }

}
