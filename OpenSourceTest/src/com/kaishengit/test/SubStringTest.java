package com.kaishengit.test;

import org.junit.Test;

import javax.servlet.http.Part;

public class SubStringTest {
    @Test
    public void subTest(){
        String str = "form-data; name=\"doc\"; filename=\"123.txt\"";
        String name = str.substring(str.indexOf("filename=\""));
        name = name.substring(name.indexOf("\"")+1,name.length()-1);
        System.out.println(name);
    }
}
