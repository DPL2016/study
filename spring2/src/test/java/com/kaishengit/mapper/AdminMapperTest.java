package com.kaishengit.mapper;

import com.kaishengit.pojo.Admin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class AdminMapperTest {
    @Inject
    private AdminMapper adminMapper;

    @Test
    public void testFindById(){
        Admin admin = adminMapper.findByName("n1");
        Assert.assertNotNull(admin);
    }
}
