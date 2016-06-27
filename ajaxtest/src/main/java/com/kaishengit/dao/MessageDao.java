package com.kaishengit.dao;

import com.kaishengit.entity.Message;
import com.kaishengit.util.DBHelp;
import com.kaishengit.util.EhCacheUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MessageDao {
    private Logger logger = LoggerFactory.getLogger(MessageDao.class);
    public List<Message> findAll() {
        List<Message> messageList = (List<Message>) EhCacheUtil.get("messageList");
        if (messageList==null){
            String sql = "select*from message order by id desc";
            messageList= DBHelp.query(sql,new BeanListHandler<>(Message.class));
            EhCacheUtil.set("messageList",messageList);
        }else {
            logger.debug("load message from cache");
        }
        return messageList;
    }

    public List<Message> findByMaxId(String maxId) {
        String sql = "select*from message where id > ? order by id desc";
        return DBHelp.query(sql,new BeanListHandler<>(Message.class),maxId);
    }

    public Message findById(Integer id){
        Message message = (Message) EhCacheUtil.get("message:"+id);
        if (message==null){
            String sql = "select*from message where id = ?";
            message = DBHelp.query(sql,new BeanHandler<>(Message.class),id);
            EhCacheUtil.set("message:"+id,message);
        }else {
            logger.debug("load message from cache");
        }
        return message;
    }

    public void save(Message message){
        String sql = "insert into message(message,author) values (?,?)";
        DBHelp.update(sql,message.getMessage(),message.getAuthor());
        EhCacheUtil.remove("messageList");
    }
}
