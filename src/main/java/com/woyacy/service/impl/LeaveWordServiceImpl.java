package com.woyacy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woyacy.bean.LeaveWordBean;
import com.woyacy.bean.PageBean;
import com.woyacy.dao.LeaveWordMapper;
import com.woyacy.service.LeaveWordService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

@Service
public class LeaveWordServiceImpl implements LeaveWordService {

    @Autowired
    private LeaveWordMapper leaveWordMapper;


    public void addLeaveWord(LeaveWordBean leaveWordBean) {
        leaveWordMapper.insertLeaveWord(leaveWordBean);
    }

    public void deleteLeaveWordById(Long[] lds) {
        List<Long> ids = Arrays.asList(lds);
        if (isNotEmpty(ids)) {
            ids.stream().forEach(id -> {
                leaveWordMapper.deleteByIds(id);
            });
        }
    }

    @Override
    public void updateLeaveWordByStatus(Long [] ids) {
        List<Long> longs = Arrays.asList(ids);
        if (CollectionUtils.isNotEmpty(longs)){
            longs.forEach(id->{
                LeaveWordBean leaveWordBean = new LeaveWordBean();
                leaveWordBean.setId(id);
                //更改状态为已读
                leaveWordBean.setStatus(LeaveWordBean.READ_STATUS);
                //更新状态
                leaveWordMapper.updateLeaveWordByld(leaveWordBean);
            });
        }

    }

    @Override
    public LeaveWordBean selectLeaveWordByKey(Long id) {
        return leaveWordMapper.selectByKey(id);
    }

    @Override
    public PageBean finPage(int pageNum, int pageSize) {
        // pageNum 当前第几页
        // pageSize 每页几条数据
        PageHelper.startPage(pageNum, pageSize);
        // 转换page类型
        Page<LeaveWordBean> page = (Page<LeaveWordBean>) leaveWordMapper.selectAllLeaveWord();
        return new PageBean(page.getTotal(), page.getResult());
    }

    @Override
    public List<LeaveWordBean> selectAllLeaveWord() {
        return leaveWordMapper.selectAllLeaveWord();
    }

    @Override
    public List<LeaveWordBean> findLeaveWordByCondition(Map<String, Object> map) {
        return leaveWordMapper.findLeaveWordByCondition(map);
    }

    @Override
    public void deleteLeaveWordById(Long id) {
        leaveWordMapper.deleteByIds(id);
    }
}
