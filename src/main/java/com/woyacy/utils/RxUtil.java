package com.woyacy.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * 系统通用工具类
 *
 * @author glh
 *
 */
public class RxUtil {

    /**
     * 获取唯一的32位字符串
     *
     * @return
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }

    /**
     * 获取系统当时时间。时间格式：yyyy-MM-dd HH:mm:ss
     *
     * @return 时间格式：yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentDateTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = formatter.format(currentTime);
        return datetime;
    }

    /**
     * 获取系统当时时间。时间格式：yyyy-MM-dd
     *
     * @return 时间格式：yyyy-MM-dd
     */
    public static String getCurrentDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(currentTime);
        return date;
    }

    /**
     * 获取四舍五入后的数字
     *
     * @param number
     *            要格式化的数字
     * @param decimalNumber
     *            需要保留的小数位数。1保留一位小数，2保留两位小数，0为没有小数，返回整数。
     * @return 格式化后的数字
     */
    public static String getNumber_ROUND_HALF_UP(String number, int decimalNumber) {
        String pattern = "0";
        if (decimalNumber > 0) {
            pattern = "0.";
        }
        String decimal = "";
        for (int i = 0; i < decimalNumber; i++) {
            decimal += "0";
        }
        DecimalFormat df = new DecimalFormat(pattern + decimal);
        number = df.format(Double.parseDouble(number));
        return number;
    }

}
