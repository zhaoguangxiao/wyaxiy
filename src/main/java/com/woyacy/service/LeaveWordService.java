package com.woyacy.service;

import com.woyacy.bean.LeaveWordBean;
import com.woyacy.bean.PageBean;

import java.util.List;
import java.util.Map;

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
     * @param ids
     */
    public void updateLeaveWordByStatus(Long [] ids);


    /**
     * 根据id查询留言
     * @param id
     * @return
     */
    public LeaveWordBean selectLeaveWordByKey(Long id);


    /**
     * 	分页查询数据
     */
    public PageBean finPage(int pageNum, int pageSize);


    /**
     * 查询全部留言数据
     * @return
     */
    public List<LeaveWordBean> selectAllLeaveWord();


    public List<LeaveWordBean> findLeaveWordByCondition(Map<String,Object> map);

    public void deleteLeaveWordById(Long id);


}
