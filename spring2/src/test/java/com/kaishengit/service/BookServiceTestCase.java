package com.kaishengit.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookServiceTestCase {
    @Test
    public void testBookDao(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.show();
    }
}
