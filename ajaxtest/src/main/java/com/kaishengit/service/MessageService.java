package com.kaishengit.service;

import com.kaishengit.dao.MessageDao;
import com.kaishengit.entity.Message;

import java.util.List;

public class MessageService {
    private MessageDao dao = new MessageDao();
    public List<Message> findAll(){
        return dao.findAll();
    }

    public List<Message> findByMaxId(String maxId) {
        return dao.findByMaxId(maxId);
    }
}
