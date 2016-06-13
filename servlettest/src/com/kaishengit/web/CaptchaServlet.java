package com.kaishengit.web;

import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/pic.png")
public class CaptchaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConfigurableCaptchaService service = new ConfigurableCaptchaService();
        service.setColorFactory(new SingleColorFactory(new Color(20,60,170)));
        service.setFilterFactory(new CurvesRippleFilterFactory(service.getColorFactory()));
        OutputStream outputStream = resp.getOutputStream();

        String captcha = EncoderHelper.getChallangeAndWriteImage(service,"png",outputStream);
        HttpSession session = req.getSession();
        session.setAttribute("captcha",captcha);

        outputStream.flush();
        outputStream.close();
    }
}
