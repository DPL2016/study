package com.kaishengit.web;

import com.kaishengit.entity.Document;
import com.kaishengit.service.DocumenService;

import javax.print.Doc;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        DocumenService documenService = new DocumenService();
        List<Document> documentList =documenService.findAllDocument();
        req.setAttribute("documentList",documentList);
        req.getRequestDispatcher("/WEB-INF/views/filelist.jsp").forward(req,resp);
    }

}
