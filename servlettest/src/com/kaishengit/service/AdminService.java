package com.kaishengit.service;

import com.kaishengit.dao.AdminDAO;
import com.kaishengit.entity.Admin;
import org.apache.commons.codec.digest.DigestUtils;
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
    public Admin login(String username, String password){
        Admin admin = dao.find(username);
        if (admin!=null&&admin.getPassword().equals(DigestUtils.md5Hex(password+SALT))){
            logger.debug("获取admin对象成功");
            return admin;
        }
        logger.warn("获取admin对象失败");
        return null;
    }
}
