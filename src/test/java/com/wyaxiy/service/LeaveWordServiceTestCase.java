package com.wyaxiy.service;

import com.woyacy.bean.LeaveWordBean;
import com.woyacy.service.LeaveWordService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
            LeaveWordBean bean = new LeaveWordBean();
            bean.setUname("ninhaoa");
            bean.setUrl("hanbaba.com.cn");
            bean.setPhone("17613720880");
            bean.setCreateTime(new Date());
            bean.setCategory(1);//1为粥员外
            bean.setIp("10.40.39.68");
            bean.setStatus(LeaveWordBean.UNREAD_STATUS); //默认未读状态
            bean.setDistrict("上海");
            bean.setHasComputer(LeaveWordBean.IS_MOBILE);
            leaveWordService.addLeaveWord(bean);
    }

    /**
     * 批量删除 留言
     */
    @Test
    public void deleteLeaveWord(){
        Long [] aLong = new Long[]{Long.valueOf(4050)};
        leaveWordService.deleteLeaveWordById(aLong);
    }



    @Test
    public void updateLeaveWordStatus(){
        Long [] longs =new Long[]{1L};
        leaveWordService.updateLeaveWordByStatus(longs);
    }


    @Test
    public void selectKey(){
        LeaveWordBean leaveWordBean = leaveWordService.selectLeaveWordByKey(4051L);
        Assert.assertNotNull(leaveWordBean.getId()!=null);
    }

    /**
     * 根据条件查询
     */
    @Test
    public void findLeaveWordByCondition(){
        HashMap<String, Object> hashMap = new HashMap<>();
        //hashMap.put("uname","op");
        //hashMap.put("phone","49");
        hashMap.put("beginDate","2019-05-10 16:43:58");
        hashMap.put("endDate","2019-05-11 16:43:58");
        leaveWordService.findLeaveWordByCondition(hashMap);
    }


    @Test
    public void deleteById(){
        leaveWordService.deleteLeaveWordById(3L);
    }


    @Test
    public void findAll(){
        leaveWordService.findAll();
    }

}
