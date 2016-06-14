package com.kaishengit.util;

import com.kaishengit.exception.DataAccessException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailUtil {
    private static Logger logger = LoggerFactory.getLogger(EmailUtil.class);

    /**
     * 发生一封文本邮件
     * @param subject 主题
     * @param msg 内容
     * @param toAddress 收件地址
     */
    public static void sendSimpleEmail(String subject,String msg,String toAddress){
        SimpleEmail email = new SimpleEmail();
        email.setHostName(Config.get("mail.hostname"));
        email.setSmtpPort(Integer.parseInt(Config.get("mail.port")));
        email.setAuthentication(Config.get("mail.username"),Config.get("mail.password"));
        email.setCharset(Config.get("mail.charset"));
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
