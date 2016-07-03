package com.kaishengit.dao;

import com.kaishengit.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class UserDaoImpl1 implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "insert into user(name,password,address) values(?,?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getPassword(),user.getAddress());
    }

    @Override
    public User findById(Integer id) {
        String sql ="select*from user where id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Long count() {
        return null;
    }
}
