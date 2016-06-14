package com.kaishengit.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CodecTest {
    //md5测试
    @Test
    public void codecTest() {
        String password = "123";
        String salt = "qwerirux";
        password = DigestUtils.md5Hex(password + salt);
        System.out.println(password);

    }

    //sha-1 测试
    @Test
    public void shaTest() {
        String password = "1231232";
        String salt = "qowejiewop";
        password = DigestUtils.sha1Hex(password + salt);
        System.out.println(password);
    }

    //文件md5测试
    @Test
    public void fileMd5Test() throws Exception {
        FileInputStream inputStream = new FileInputStream(new File("D:/mylog2.log"));
        String md5 = DigestUtils.md5Hex(inputStream);
        System.out.println(md5);

    }
}
