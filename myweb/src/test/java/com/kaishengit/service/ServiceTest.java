package com.kaishengit.service;

import com.kaishengit.entity.Message;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ServiceTest {
    @Test
    public void serviceTest(){
        MessageService ms = new MessageService();
        List<Message>list = ms.findAll();
        Assert.assertNotNull(list);
    }
}
