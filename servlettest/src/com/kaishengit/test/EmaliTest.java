package com.kaishengit.test;

import com.kaishengit.util.EmailUtil;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;

public class EmaliTest {
    //发普通文本邮件
    @Test
    public void emailTest(){
        SimpleEmail email = new SimpleEmail();
        email.setAuthentication("dpl904","d940754079");
        email.setHostName("smtp.126.com");
        email.setSmtpPort(25);
        try{
            email.setFrom("dpl904@126.com");
            email.setSubject("文本邮件");
            email.setMsg("文本邮件测试");
            email.addTo("1542294533@qq.com");
            email.send();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void emailUtilTest(){
        EmailUtil.sendSimpleEmail("今天的主题","吃饭","1542294533@qq.com");
    }

}
