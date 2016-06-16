package com.kaishengit.web;

import com.kaishengit.service.DocumenService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/common/load")
public class CommentFileUploadServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(CommentFileUploadServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/commonload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(req)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024 * 64);
            ServletContext servletContext = getServletContext();
            //tomcat的temp目录
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            fileUpload.setFileSizeMax(10 * 1024 * 1024);
            logger.debug("fileUpload:{}", fileUpload);
            try {
                List<FileItem> items = fileUpload.parseRequest(req);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        String fieldName = item.getFieldName();
                        logger.debug("fieldName:{}", fieldName);
                        if ("describe".equals(fieldName)) {
                            String value = item.getString();
                           value =  new String(value.getBytes("UTF-8"),"ISO8859-1");
                            logger.debug("{}->{}", fieldName, value);
                        }
                    } else {
                        String fileName = item.getName();
                        long size = item.getSize();
                        String ContentType = item.getContentType();
                        DocumenService documenService = new DocumenService();
                        documenService.updateFile(fileName, size, item.getInputStream());
                        logger.debug("ContentType:{}", ContentType);
                    }
                }
                resp.sendRedirect("/list");
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }
}
