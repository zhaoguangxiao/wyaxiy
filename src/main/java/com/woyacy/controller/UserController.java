package com.woyacy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class UserController {


    @RequestMapping("/login")
    public String Login(){
      System.out.println("6666");
        return "tetsss";
    }

}
