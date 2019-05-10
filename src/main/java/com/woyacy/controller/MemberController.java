package com.woyacy.controller;

import com.woyacy.bean.LeaveWordBean;
import com.woyacy.bean.PageBean;
import com.woyacy.service.LeaveWordService;
import com.woyacy.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import static com.woyacy.bean.LeaveWordBean.ZHOU_YUAN_WAI;

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


    @RequestMapping("/updateById")
    public boolean updateLeaveWordById(Long id) {
        try {
            Long[] longs = new Long[]{id};
            leaveWordService.updateLeaveWordByStatus(longs);
            return true;
        } catch (Exception e) {
            return false;
        }

    }


    /**
     * 根据搜索条件导出Excel
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public boolean export(String name, String tell, String beginTime, String endTime) throws Exception {
        //查询数据
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("uname", name);
        hashMap.put("phone", tell);
        hashMap.put("beginDate", beginTime);
        hashMap.put("endDate", endTime);
        List<LeaveWordBean> leaveWordByCondition = leaveWordService.findLeaveWordByCondition(hashMap);
        String[][] strings = changeList(leaveWordByCondition);
        //设置单元格的宽度
        int[] columnWidth = {15, 15, 30, 30, 30, 30, 30, 30, 30};
        //设置excel文件的明后才能
        String[] columnName = {"id", "名字", "手机号", "区域", "状态", "url", "创建时间", "ip", "所属商家"};
        try {
            String exportXLS = ExcelUtil.ExportExcel(9, columnWidth, "留言导出文件", columnName, strings);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 根据条件搜索
     *
     * @return
     */
    @RequestMapping("/precis")
    public List<LeaveWordBean> precisSearch(String name, String tell, String beginTime, String endTime) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("uname", name);
        hashMap.put("phone", tell);
        hashMap.put("beginDate", beginTime);
        hashMap.put("endDate", endTime);
        return leaveWordService.findLeaveWordByCondition(hashMap);
    }


    /**
     * 把对象转化为二维数组
     *
     * @param beanLists
     * @return
     */
    private String[][] changeList(List<LeaveWordBean> beanLists) {
        //把集合数据转化为二维数组
        String[][] strs = new String[beanLists.size()][9];
        for (int i = 0; i < beanLists.size(); i++) {
            LeaveWordBean leaveWordBean = beanLists.get(i);
            strs[i][0] = String.valueOf(leaveWordBean.getId());
            strs[i][1] = leaveWordBean.getUname();
            strs[i][2] = leaveWordBean.getPhone();
            strs[i][3] = leaveWordBean.getDistrict();
            strs[i][4] = String.valueOf(leaveWordBean.getStatus());
            strs[i][5] = leaveWordBean.getUrl();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            strs[i][6] = dateFormat.format(leaveWordBean.getCreateTime());
            strs[i][7] = leaveWordBean.getIp();
            if (leaveWordBean.getCategory() == ZHOU_YUAN_WAI) {
                strs[i][8] = String.valueOf("粥员外");
            }

        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length; j++) {
            }
        }
        return strs;
    }

}
