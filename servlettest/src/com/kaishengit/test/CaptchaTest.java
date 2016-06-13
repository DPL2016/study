package com.kaishengit.test;

import org.junit.Test;
import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;

import java.awt.*;
import java.io.FileOutputStream;

public class CaptchaTest {
    @Test
    public void captcharTestCase() throws Exception {
        ConfigurableCaptchaService service = new ConfigurableCaptchaService();
        service.setColorFactory(new SingleColorFactory(new Color(20,60,170)));
        service.setFilterFactory(new CurvesRippleFilterFactory(service.getColorFactory()));

        RandomWordFactory factory = new RandomWordFactory();
        factory.setMinLength(4);
        factory.setMaxLength(4);
        factory.setCharacters("123456789");
        service.setWordFactory(factory);

        FileOutputStream outputStream = new FileOutputStream("D:/pic.png");
        EncoderHelper.getChallangeAndWriteImage(service,"png",outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
