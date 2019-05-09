package com.woyacy.controller;

import com.woyacy.bean.LeaveWordBean;
import com.woyacy.bean.PageBean;
import com.woyacy.service.LeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 后台ajax请求地址
 */
@RestController
@RequestMapping("/Administrator")
public class MemberController {


    @Autowired
    private LeaveWordService leaveWordService;


    @RequestMapping("/search")
    public PageBean searchLeaveWord(int pageNum, int pageSize) {
        return leaveWordService.finPage(pageNum, pageSize);
    }

    @RequestMapping("/all")
    public List<LeaveWordBean> findAll() {
        return leaveWordService.selectAllLeaveWord();
    }


    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete")
    public boolean deleteLeaveWordById(Long[] ids) {
        try {
            leaveWordService.deleteLeaveWordById(ids);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 根据id删除留言
     *
     * @param id
     * @return
     */
    @RequestMapping("deleteById")
    public boolean deleteLeaveWordById(Long id) {
        if (id == null) return false;
        try {
            leaveWordService.deleteLeaveWordById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 批量更改留言状态
     *
     * @param ids
     * @return
     */
    @RequestMapping("/update")
    public boolean updateLeaveWord(Long[] ids) {
        try {
            leaveWordService.updateLeaveWordByStatus(ids);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 根据搜索条件导出Excel
     */
    @RequestMapping("/export")
    public void export() {

    }

    /**
     * 根据条件搜索
     * @return
     */
    @RequestMapping("/precis")
    public List<LeaveWordBean> precisSearch(String name, String tell, Date beginTime,Date endTime){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("uname",name);
        hashMap.put("phone",tell);
        hashMap.put("beginDate",beginTime);
        hashMap.put("endDate",endTime);
        return leaveWordService.findLeaveWordByCondition(hashMap);
    }


}
