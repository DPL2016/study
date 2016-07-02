package com.kaishengit.dao;

import com.kaishengit.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;

import javax.inject.Inject;
import javax.inject.Named;


import java.util.List;
@Named
public class UserDaoImpl1 implements UserDao {

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        String sql = "insert into user(name,password,address) values(?,?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getPassword(),user.getAddress());
    }

    @Override
    public User findById(Integer id) {
        String sql = "select*from user where id= ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public List<User> findAll() {
        String sql = "select*from user";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public void update(User user) {
        String sql = "update user set password=?,address=? where id =?";
        jdbcTemplate.update(sql,user.getPassword(),user.getAddress(),user.getId());
    }

    @Override
    public Long count() {
        String sql = "select count(*) from user";
        return jdbcTemplate.queryForObject(sql,new SingleColumnRowMapper<Long>());
    }

}
