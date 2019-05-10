package com.woyacy.utils;

import java.io.File;

/**
 * 路径工具
 * @author glh
 *
 */
public class PathUtil {

    /**
     * 得到项目根目录物理路径
     * @return
     */
    public static String getWebRootPath()
    {
        return System.getProperty("user.dir");
    }
    /**
     * 得到项目WEB-INF目录物理路径
     * @return
     */
    public static String getWebInfPath()
    {
        return getWebRootPath()+"WEB-INF";
    }
    /**
     * 得到ClassPath物理路径
     * @return
     */
    public static String getClassPath()
    {
        return getWebInfPath()+ File.separatorChar+"classes";
    }
    /**
     * 得到附件目录物理路径
     * @return
     */
    public static String getUploadPath()
    {
        //getWebInfPath()+File.separatorChar+"upload"
        return "D:";
    }



}
