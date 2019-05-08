package com.woyacy.controller;

import com.woyacy.bean.UserBean;
import com.woyacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public int login(String name,String pwd){
        UserBean userBean = new UserBean();
        userBean.setName(name);
        userBean.setPwd(pwd);
        int userByNameAndPwd = userService.findUserByNameAndPwd(userBean);
        return userByNameAndPwd>0?1:0;
    }
}
