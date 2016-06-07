package com.kaishengit.test;

import com.kaishengit.dao.UserDAO;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class testCase {
   private UserDAO dao = new UserDAO();
    @Test
    public void testCount(){
        assertEquals(new Long(11),dao.count());
    }
    @Test
    public void test(){
        Object obj = dao.findOne(1);
        assertNotNull(obj);

    }
}
