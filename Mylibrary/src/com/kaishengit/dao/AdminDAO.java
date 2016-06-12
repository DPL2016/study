package com.kaishengit.dao;


import com.kaishengit.entity.Admin;
import com.kaishengit.util.DBHelp;
import org.apache.commons.dbutils.handlers.BeanHandler;


public class AdminDAO {
	public Admin find(String name, String pwd){
		String sql = "select * from admin where name = ? and password = ?";
		return DBHelp.query(sql,new BeanHandler<>(Admin.class),name,pwd);
	}
}
