package com.woyacy.controller;

import com.woyacy.bean.UserBean;
import com.woyacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test(){
        List<UserBean> userBeans = userService.selectAll();
        return "test";
    }
}
