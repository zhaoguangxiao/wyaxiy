package com.woyacy.controller;

import com.woyacy.bean.LeaveWordBean;
import com.woyacy.service.LeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/leave")
public class LeaveWordController {


    @Autowired
    private LeaveWordService leaveWordService;


    @RequestMapping("/insert")
    public boolean saveLeaveWord(String name,String url,String tell,int category,String ip,String description){
        try {
            LeaveWordBean wordBean = new LeaveWordBean();
            wordBean.setUname(name);
            wordBean.setUrl(url);
            wordBean.setPhone(tell);
            wordBean.setCreateTime(new Date());
            wordBean.setCategory(category);
            wordBean.setIp(ip);
            wordBean.setStatus(LeaveWordBean.UNREAD_STATUS); //默认未读状态
            wordBean.setDistrict(description);
            leaveWordService.addLeaveWord(wordBean);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
