package com.kaishengit.service;

import com.kaishengit.dao.MessageDAO;
import com.kaishengit.entity.Message;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ServiceTest {
    private MessageService ms = new MessageService();
    @Test
    public void serviceTest(){

        List<Message>list = ms.findAll();
        Assert.assertNotNull(list);
    }

    @Test
    public void delTest(){
        ms.delMessage("");
    }
@Test
    public void addTest(){
        Message message = new Message();
        message.setCommand("hah");
        message.setDescription("1345");
        message.setContent("asdff");
        MessageDAO dao = new MessageDAO();
        dao.addMeaaage(message);
    }
}
