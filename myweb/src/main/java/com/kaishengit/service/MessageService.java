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
    private Message message = new Message();

    /**
     * 查询message全部数据
     * @return 返回List对象数组
     */
    public List<Message> findAll() {
       return dao.findAll();
    }

    /**
     * 新增数据
     * @param command 指令
     * @param description 描述
     * @param content 简介
     * 调用MessageDAO中的addMessage方法，新增数据
     */
    public void addMessage(String command, String description, String content) {
        message.setCommand(command);
        message.setDescription(description);
        message.setContent(content);
        dao.addMeaaage(message);
    }

    /**
     * 删除数据
     * @param command command
     * 调用MessageDAO中的delMessage方法，删除数据
     */
    public boolean delMessage(String command){
      return dao.delMessage(command);
    }

}
