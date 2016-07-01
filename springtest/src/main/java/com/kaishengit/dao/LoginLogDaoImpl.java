package com.kaishengit.dao;

import com.kaishengit.pojo.LoginLog;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LoginLogDaoImpl implements LoginLogDao {

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(LoginLog loginLog) {
        String sql = "insert into loginlog(ip,userid) values (?,?)";
        jdbcTemplate.update(sql,loginLog.getIp(),loginLog.getUserid());
    }
}