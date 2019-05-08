package com.wyaxiy.service;

import com.woyacy.bean.UserBean;
import com.woyacy.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    public void findUserByNamePwd(){
        UserBean bean = new UserBean();
        bean.setName("admin");
        bean.setPwd("123456");
        userService.findUserByNameAndPwd(bean);
    }



}
