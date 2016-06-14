package com.kaishengit.service;

import com.kaishengit.dao.AdminDAO;
import com.kaishengit.entity.Admin;
import com.kaishengit.util.EmailUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminService {
    private Logger logger = LoggerFactory.getLogger(AdminService.class);
    private AdminDAO dao = new AdminDAO();
    private final String SALT = "qwerirux";
    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 如果不是null，返回一个admin对象
     */
    public Admin login(final String username, String password){
       final Admin admin = dao.find(username);
        //password = DigestUtils.md5Hex(password+SALT);
        if (admin!=null&&admin.getPassword().equals(password)){
            logger.debug("获取admin对象成功");
           Thread thread =  new Thread(new Runnable() {
                @Override
                public void run() {
                    EmailUtil.sendSimpleEmail("登录提醒","您的账号"+username+"在"+ DateTime.now().toString("yyyy-MM-dd HH:mm:ss")+"登录",admin.getAddress());
                }
            });
            thread.start();
            return admin;
        }
        logger.warn("获取admin对象失败");
        return null;
    }
}
