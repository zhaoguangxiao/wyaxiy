package com.wyaxiy.service;

import com.woyacy.bean.LeaveWordBean;
import com.woyacy.service.LeaveWordService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:*.xml"})
public class LeaveWordServiceTestCase {

    @Autowired
    private LeaveWordService leaveWordService;


    @Test
    public void assertNotNull(){
        Assert.assertNotNull(leaveWordService);
    }

    /**
     * 添加留言
     */
    @Test
    public void saveLeaveWord(){


        for (int i = 10; i < 30; i++) {
            LeaveWordBean bean = new LeaveWordBean();
            bean.setUname("zs1"+i);
            bean.setUrl("hanbaba.com.cn");
            bean.setPhone("17613720880");
            bean.setCreateTime(new Date());
            bean.setCategory(1);//1为粥员外
            bean.setIp("10.40.39.68");
            bean.setStatus(LeaveWordBean.UNREAD_STATUS); //默认未读状态
            bean.setDistrict("上海");
            leaveWordService.addLeaveWord(bean);
        }
    }

    /**
     * 批量删除 留言
     */
    @Test
    public void deleteLeaveWord(){
        Long [] aLong = new Long[]{Long.valueOf(2)};
        leaveWordService.deleteLeaveWordById(aLong);
    }



    @Test
    public void updateLeaveWordStatus(){
        LeaveWordBean bean = new LeaveWordBean();
        bean.setId(1L);
        bean.setStatus(LeaveWordBean.UNREAD_STATUS);
        leaveWordService.updateLeaveWordByStatus(bean);
    }


    @Test
    public void selectKey(){
        LeaveWordBean leaveWordBean = leaveWordService.selectLeaveWordByKey(1L);
        Assert.assertNotNull(leaveWordBean.getId()!=null);
    }



}
