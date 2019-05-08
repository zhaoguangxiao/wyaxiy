package com.woyacy.service;

import com.woyacy.bean.LeaveWordBean;

public interface LeaveWordService {
    /**
     * 添加留言方法
     * @param leaveWordBean
     */
    public void  addLeaveWord(LeaveWordBean leaveWordBean);

    /**
     * 批量删除留言
     * @param lds
     */
    public void deleteLeaveWordById(Long [] lds);

    /**
     * 更新已读/未读状态
     * @param leaveWordBean
     */
    public void updateLeaveWordByStatus(LeaveWordBean leaveWordBean);


    public LeaveWordBean selectLeaveWordByKey(Long id);
}
