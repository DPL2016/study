package com.kaishengit.web;

import com.kaishengit.dao.AdminDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/username")
public class CheckUsername extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(CheckUsername.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.addHeader("pragma","no-cache");
        resp.addHeader("cache-control","no-cache");
        resp.addHeader("expires","0");
        String username = req.getParameter("username");
        username = new String(username.getBytes("ISO8859-1"),"UTF-8");
        logger.debug("usename:{}",username);
        AdminDAO dao = new AdminDAO();
        PrintWriter out = resp.getWriter();
        logger.debug("admin:",dao.queryAdminByName(username));
        if (dao.queryAdminByName(username)!=null){
            out.print("no");
        }else {
            out.print("yes");
        }
    }
}
