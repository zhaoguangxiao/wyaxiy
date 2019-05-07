package com.wyaxiy.service;

import com.woyacy.bean.UserBean;
import com.woyacy.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:*.xml"})
public class UserServiceTestCase {

    @Autowired
    private UserService userService;



    @Test
    public void assertNotNull(){
        Assert.assertNotNull(userService);
    }

    @Test
    public void findAll(){
        List<UserBean> userBeans = userService.selectAll();
        Assert.assertNotNull(!userBeans.isEmpty());
    }
}
