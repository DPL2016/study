package com.kaishengit.test;

import com.kaishengit.dao.MessageDao;
import com.kaishengit.entity.Message;
import com.kaishengit.service.MessageService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MessageTestCase {
    @Test
    public void testFindAll(){
        MessageDao dao = new MessageDao();
        List<Message>list = dao.findAll();
        Assert.assertNotNull(list);
    }

    @Test
    public void testService(){
        MessageService ms = new MessageService();
        List<Message>list = ms.findByMaxId("1");
        Assert.assertNotNull(list);
    }
}
