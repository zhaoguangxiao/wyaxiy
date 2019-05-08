package com.woyacy.controller;

import com.woyacy.bean.PageBean;
import com.woyacy.service.LeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台ajax请求地址
 */
@Controller
@RequestMapping("/member")
public class MemberController {


    @Autowired
    private LeaveWordService leaveWordService;


    @RequestMapping("/search")
    public PageBean searchLeaveWord(int pageNum, int pageSize){
       return leaveWordService.finPage(pageNum,pageSize);
    }


}
