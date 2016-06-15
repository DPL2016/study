package com.kaishengit.service;

import com.kaishengit.dao.AdminDao;
import com.kaishengit.entity.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminService {
   private Logger logger = LoggerFactory.getLogger(AdminService.class);
    /**
     * 用户登录
     * @param name 用户名
     * @param password 密码
     * @return 如果用户名和密码匹配，返回一个admin对象，否则返回null
     */
    public Admin login(String name,String password){
        AdminDao dao = new AdminDao();
        Admin admin = dao.queryAdminByName(name);
        if (admin!=null&&admin.getPassword().equals(password)){
            logger.debug("获取admin对象成功");
            return admin;
        }
        logger.warn("获取admin对象失败");
        return null;
    }
}
