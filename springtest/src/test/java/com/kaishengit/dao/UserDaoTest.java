package com.kaishengit.dao;

import com.kaishengit.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class UserDaoTest {
    @Inject
    private UserDao userDao;

    @Test
    public void testSave(){
        User user = new User();
        user.setName("Spring");
        user.setPassword("147258369");
        user.setAddress("LA");
        userDao.save(user);
    }

    @Test
    public void testDelete(){
        userDao.delete(5);
    }

    @Test
    public void testUpdate(){
        User user = userDao.findById(4);
        user.setName("spring");
        user.setPassword("147852");
        user.setAddress("UK");
        userDao.update(user);
    }

    @Test
    public void testFindAll(){
        List<User> userList = userDao.findAll();
        for(User user:userList){
            System.out.println(user);
        }
        Assert.assertEquals(userList.size(),2);
    }

    @Test
    public void testFindByName(){
        User user = userDao.findByName("spring");
        Assert.assertNotNull(user);
    }


    @Test
    public void testCount(){
        Long count = userDao.count();
        System.out.println(count);
    }

}
