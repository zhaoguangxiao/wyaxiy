package com.woyacy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class HomeController {


    @RequestMapping("/login")
    public String Login(){
        return "index2";
    }

}
