package com.kaishengit.web;

import com.kaishengit.entity.Document;
import com.kaishengit.service.DocumenService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/preview")
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String md5 = req.getParameter("file");
        String down = req.getParameter("down");
        if (StringUtils.isNotEmpty(md5)){
            DocumenService documenService = new DocumenService();
            Document document =documenService.findDocumentByMd5(md5);
            if (document==null){
                resp.sendError(404);
            }else {
                String saveName = document.getSavename();
                File file = new File("D:/122",saveName);
                if (file.exists()){
                    if ("true".equals(down)){
                        resp.setContentType("application/octet-stream");
                        String fileName = new String(document.getFilename().getBytes("UTF-8"),"ISO8859-1");
                        resp.addHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");
                        resp.setContentLength(document.getSize().intValue());
                    }
                    FileInputStream fis = new FileInputStream(file);
                    OutputStream os = resp.getOutputStream();
                    IOUtils.copy(fis,os);
                    os.flush();
                    os.close();
                    fis.close();
                }else {
                    resp.sendError(404);
                }
            }
        }else {
            resp.sendError(404);
        }
    }
}
