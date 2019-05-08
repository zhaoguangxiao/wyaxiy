package com.woyacy.dao;

import com.woyacy.bean.LeaveWordBean;

import java.util.List;

public interface LeaveWordMapper {

    public void insertLeaveWord(LeaveWordBean leaveWordBean);


    public void deleteByIds(Long id);


    public void updateLeaveWordByld(LeaveWordBean leaveWordBean);


    public LeaveWordBean selectByKey(Long id);


    public List<LeaveWordBean> selectAllLeaveWord();



}
