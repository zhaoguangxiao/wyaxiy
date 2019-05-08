package com.woyacy.controller;

import com.woyacy.bean.LeaveWordBean;
import com.woyacy.service.LeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/leave")
public class LeaveWordController {


    @Autowired
    private LeaveWordService leaveWordService;


    @RequestMapping("/insert")
    public int saveLeaveWord(@RequestBody LeaveWordBean leaveWordBean){
        try {
            leaveWordService.addLeaveWord(leaveWordBean);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @RequestMapping("/search")
    @ResponseBody
    public String hello(){
        return "66666";
    }

}
