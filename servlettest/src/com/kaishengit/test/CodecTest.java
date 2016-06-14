package com.kaishengit.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class CodecTest {
    //md5测试
    @Test
    public void codecTest(){
        String password = "1231232";
        String salt = "qwerirux";
        password = DigestUtils.md5Hex(password+salt);
        System.out.println(password);
        
    }
}
