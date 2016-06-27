package com.kaishengit.test;

import com.kaishengit.dao.MessageDao;
import com.kaishengit.entity.Message;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CacheTest {
    private MessageDao dao = new MessageDao();
    @Test
    public void findByIdTest(){
        Message message = dao.findById(1);
        message = dao.findById(1);
        message = dao.findById(1);
        message = dao.findById(1);
        Assert.assertNotNull(message);
    }
    @Test
    public void testFindAll(){
        List<Message> messageList = dao.findAll();
        messageList = dao.findAll();
        Message message = new Message();
        message.setAuthor("lili");
        message.setMessage("hi");
        dao.save(message);
        messageList = dao.findAll();
        messageList = dao.findAll();
        Assert.assertNotNull(messageList);
    }
}
