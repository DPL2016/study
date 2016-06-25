package com.kaishengit.service;

import com.kaishengit.dao.MessageDAO;
import com.kaishengit.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 业务层，负责处理业务逻辑
 */
public class MessageService {
    private Logger logger = LoggerFactory.getLogger(MessageService.class);
    private MessageDAO dao = new MessageDAO();

    /**
     * 查询message全部数据
     * @return 返回List对象数组
     */
    public List<Message> findAll() {
       return dao.findAll();
    }
}
