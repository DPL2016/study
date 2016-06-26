package com.kaishengit.web;

import com.kaishengit.dao.MessageDAO;
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
 * 新增信息
 */

@WebServlet("/add")
public class AddMessage extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(Message.class);

    /**
     * doGet请求转发显示新增页面
     * @param req request
     * @param resp response
     * @throws ServletException ServletException
     * @throws IOException ServletException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/addMessage.jsp").forward(req,resp);
    }

    /**
     * doPost 获取表单数据并显示到列表页面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     *
     * 获取表单元素
     * 通过调用MessageService中的addMessage方法，新增数据
     * 重定向到list页面
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        String content = req.getParameter("content");
        new MessageService().addMessage(command,description,content);
        resp.sendRedirect("/list");

    }
}
