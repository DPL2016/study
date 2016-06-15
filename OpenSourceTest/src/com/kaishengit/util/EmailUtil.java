package com.kaishengit.util;

import com.kaishengit.exception.DataAccessException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailUtil {
    private static Logger logger = LoggerFactory.getLogger(EmailUtil.class);
    public static void sendSimpleEmail(String toAddress,String subject,String msg){
        SimpleEmail email = new SimpleEmail();
        email.setHostName(Config.get("email.hostname"));
        email.setSmtpPort(Integer.parseInt(Config.get("email.port")));
        email.setCharset(Config.get("email.charset"));
        email.setAuthentication(Config.get("email.username"),Config.get("email.password"));
        try {
            email.setFrom(Config.get("mail.fromemail"));
            email.setSubject(subject);
            email.setMsg(msg);
            email.addTo(toAddress);
            email.send();
            logger.debug("给{}发送电子邮件成功",toAddress);
        }catch (Exception e){
            logger.warn("给{}发送电子邮件失败",toAddress);
            throw new DataAccessException("邮件发送异常");
        }
    }
}
