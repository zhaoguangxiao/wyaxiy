package com.woyacy.controller;

import com.woyacy.bean.LeaveWordBean;
import com.woyacy.bean.PageBean;
import com.woyacy.service.LeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 后台ajax请求地址
 */
@RestController
@RequestMapping("/member")
public class MemberController {


    @Autowired
    private LeaveWordService leaveWordService;


    @RequestMapping("/search")
    public PageBean searchLeaveWord(int pageNum, int pageSize){
       return leaveWordService.finPage(pageNum,pageSize);
    }

    @RequestMapping("/all")
    public List<LeaveWordBean> findAll(){
        return leaveWordService.selectAllLeaveWord();
    }


}
