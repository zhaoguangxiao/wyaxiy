package com.woyacy.controller;

import com.woyacy.bean.UserBean;
import com.woyacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "login")
    public boolean login(String name,String pwd){
        UserBean userBean = new UserBean();
        userBean.setName(name);
        userBean.setPwd(pwd);
        return userService.findUserByNameAndPwd(userBean)>0;
    }
}
