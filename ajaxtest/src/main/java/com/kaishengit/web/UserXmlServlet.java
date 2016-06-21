package com.kaishengit.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/user.xml")
public class UserXmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        out.println("<users>");
        out.println("<user id=\"101\"><username>tom</username><address>USA</address></user>");
        out.println("<user id=\"102\"><username>jam</username><address>USA</address></user>");
        out.println("<user id=\"103\"><username>张三</username><address>中国</address></user>");
        out.println("<user id=\"104\"><username>李四</username><address>中国</address></user>");
        out.println("</users>");
        out.flush();
        out.close();
    }
}
