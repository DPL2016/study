package com.kaishengit;

import com.kaishengit.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class UserServiceTestCase {

    @Inject
    private UserService userService;

    @Test
    public void testLogin(){
        userService.login("spring","147852","192.168.0.1");
    }
}
