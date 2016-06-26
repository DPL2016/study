package com.kaishengit.dao;

import com.kaishengit.entity.Message;
import com.kaishengit.util.DBHelp;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;

import java.util.List;

public class MessageDAO {
    /**
     * 控制器
     * 通过sql语句，查询数据库
     */
    public List<Message> findAll() {
        String sql = "select id,command,description,content from message";
        return DBHelp.query(sql,new BeanListHandler<>(Message.class));
    }


    public void addMeaaage(Message message) {
        String sql= "insert into message (command,description,content) values(?,?,?)";
        DBHelp.update(sql,message.getCommand(),message.getDescription(),message.getContent());
    }
}
