package com.kaishengit.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");
        String filename = getFileName(part);
    }

    private String getFileName(Part part) {
        String heaserValue = part.getHeader("Content-Disposition");
        heaserValue = heaserValue.substring(heaserValue.indexOf("filename=\""));
        heaserValue = heaserValue.substring(heaserValue.indexOf("\"")+1,heaserValue.length()-1);
        return heaserValue;
    }
}
