package com.kaishengit.service;

import com.kaishengit.mapper.AdminMapper;
import com.kaishengit.pojo.Admin;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AdminService {

    @Inject
    private AdminMapper adminMapper;
    public Boolean login(String name,String password){
        Admin admin = adminMapper.findByName(name);
        if (admin!=null&& password.equals(admin.getPassword())){
            return true;
        }
        return false;
    }

}
