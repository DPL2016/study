package com.kaishengit.web;

import com.kaishengit.entity.Admin;
import com.kaishengit.service.AdminService;
import com.kaishengit.util.EmailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(LoginServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pat = req.getParameter("pat");
        String sessionCaptcha =(String) req.getSession().getAttribute("pat");
        if(pat!=null&&pat.equalsIgnoreCase(sessionCaptcha)){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            AdminService adminService = new AdminService();
            Admin admin = adminService.login(username,password);
            if (admin!=null){
                logger.debug("{}登录成功",username);
                resp.sendRedirect("/home");
            }
        }else {
            logger.warn("验证码或密码错误");
            resp.sendRedirect("/login?code=1001");
        }
    }
}
