package com.kaishengit.web;

import com.kaishengit.entity.Message;
import com.kaishengit.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除信息
 */

@WebServlet("/del")
public class DelMessage extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(Message.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        logger.debug("command",command);
        MessageService ms= new MessageService();
       if (ms.delMessage(command)){
           resp.sendRedirect("/list");
       }else {
           resp.sendError(405, "删除失败");
       }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
