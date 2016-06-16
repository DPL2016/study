package com.kaishengit.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet("/load")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/fileload.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String describe = req.getParameter("describe");
        logger.debug("描述为：{}",describe);
        Part part = req.getPart("doc");
        String contentType = part.getContentType();
        logger.debug("文件的ContentType为{}",contentType);
        long size = part.getSize();
        logger.debug("文件的大小{}",size);
        String filename = getFileName(part);
        logger.debug("文件的名称{}",filename);
        savefile(part);

    }
    private void savefile(Part part) throws IOException {
        File dir = new File("D:/122");
        if (!dir.exists()){
            dir.mkdir();
        }
        InputStream inputStream = part.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(dir,getFileName(part)));
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len=bis.read(buffer))!=-1){
            bos.write(buffer,0,len);
        }
        bos.flush();
        bos.close();
        bis.close();
    }
    private String getFileName(Part part){
        String headValue = part.getHeader("Content-Disposition");
        headValue = headValue.substring(headValue.indexOf("filename=\""));
        headValue = headValue.substring(headValue.indexOf("\"")+1,headValue.length()-1);
        logger.debug("文件名为{}",headValue);
        return headValue;
    }
}
