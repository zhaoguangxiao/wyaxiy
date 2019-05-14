package com.woyacy.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelUtil {


    private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    /**
     * 获取excel中的数据,指定开始行，可选着指定结束行
     * @param fileInputStream 			excel文件输入流
     * @param beginRow		取数数据的开始行
     * @param endRow		取数数据的结束行 ，不指定传入0
     * @param endColl		结束列
     * @return
     * @throws Exception
     */
    public static List<String[]> getExcel(FileInputStream fileInputStream, int beginRow, int endRow, int endColl) throws Exception{
        List<String[]> list = new ArrayList<String[]>();
        HSSFWorkbook wb = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet = wb.getSheetAt(0);
        if(endRow == 0 ) {
            endRow = sheet.getLastRowNum();
        }
        for (int i = beginRow; i <= endRow; i++) {
            HSSFRow row = sheet.getRow(i);
            String[] cells = new String[endColl];
            for (int j = 0; j < endColl; j++) {
                HSSFCell cell = row.getCell(j);
                try {
                    int type = cell.getCellType();
                    if(type==1) {
                        cells[j] = cell.getStringCellValue();
                    }else if(type==0) {
                        cells[j] = String.valueOf(cell.getNumericCellValue());
                        if(cells[j].substring(cells[j].length()-2, cells[j].length()).equals(".0")) {
                            cells[j] = cells[j].substring(0,cells[j].length()-2);
                        }
                    }else {
                        cells[j] = "";
                    }
                } catch (Exception e) {
                    cells[j] = "";
                }

            }
            list.add(cells);
        }
        fileInputStream.close();
        return list;
    }
    public static void main(String[] args) {
        try {
            getExcel(new FileInputStream("C:\\Users\\dnkj011\\Desktop\\学校体检导入信息.xls"), 3, 3, 27);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 获取excel中的数据，指定开始行，结束行，指定列
     * @param fileInputStream 			excel文件输入流
     * @param columnNumber	int[]需要取的列的序号
     * @param beginRow		取数数据的开始行
     * @param endRow		指定取数数据的结束行 ，不指定则出入0
     * @return
     * @throws Exception
     */
    public static List<String[]> getExcel(FileInputStream fileInputStream,int[] columnNumber,int beginRow,int endRow) throws Exception{
        List<String[]> list = new ArrayList<String[]>();
        HSSFWorkbook wb = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet = wb.getSheetAt(0);
        if(endRow == 0 ) {
            endRow = sheet.getLastRowNum();
        }

        for (int i = beginRow; i <= endRow; i++) {
            HSSFRow row = sheet.getRow(i);
            String[] cells = new String[columnNumber.length];
            for (int j = 0; j < columnNumber.length; j++) {
                HSSFCell cell = row.getCell(columnNumber[j]);
                try {
                    int type = cell.getCellType();
                    if(type==1) {
                        cells[j] = cell.getStringCellValue();
                    }else if(type==0) {
                        cells[j] = String.valueOf(cell.getNumericCellValue());
                        if(cells[j].substring(cells[j].length()-2, cells[j].length()).equals(".0")) {
                            cells[j] = cells[j].substring(0,cells[j].length()-2);
                        }
                    }else {
                        cells[j] = "";
                    }
                } catch (Exception e) {
                    cells[j] = "";
                }
            }


            list.add(cells);
        }
        return list;
    }
    /**
     * 导出数据成excel
     * @param columnNumber 	列数量
     * @param columnWidth	各列宽
     * @param titleName		标题
     * @param columnName	各列名
     * @param dataList		数据
     * @return
     */
    public static String ExportExcel(Integer columnNumber,int[] columnWidth,String titleName,String[] columnName,String[][] dataList) throws Exception{
        String time = RxUtil.getCurrentDate();
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();

        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(time);

        for (int i = 0; i < columnNumber; i++){
            sheet.setColumnWidth(i, columnWidth[i] * 270); // 单独设置每列的宽
        }

        // 第三步 ， 创建第0行 也就是标题
        HSSFRow row1 = sheet.createRow((int) 0);
        row1.setHeightInPoints(45); // 设备标题的高度
        //创建标题的单元格样式style2以及字体样式
        HSSFFont fontStyle2 = getFontStyle(wb, true, "宋体", (short)15);
        HSSFCellStyle style2 = getHeadCellStyle(wb, fontStyle2);
        // 创建标题第一列
        HSSFCell cell1 = row1.createCell(0);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, columnNumber - 1)); // 合并第0到第11列
        cell1.setCellValue(titleName); // 设置值标题
        cell1.setCellStyle(style2); // 设置标题样式



        // 创建第1行 也就是表头
        HSSFRow row = sheet.createRow((int) 1);
        row.setHeightInPoints(37);// 设置表头高度
        //设置表头单元格样式以及字体样式
        HSSFFont fontStyle = getFontStyle(wb, true, "宋体", (short)13);
        HSSFCellStyle style = getHeadCellStyle(wb, fontStyle);
        //创建表头的列
        for (int i = 0; i < columnNumber; i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(columnName[i]);
            cell.setCellStyle(style);
        }

        //创建数据单元格样式 ：自动换行 ，上下/左右居
        HSSFCellStyle cellStyle = getCellStyle(wb, null);
        //创建单元格，并设置值
        for(int i = 0; i < dataList.length; i++){
            row = sheet.createRow((int) i + 2);
            row.setHeightInPoints(20);//行高
            HSSFCell datacell = null;
            for (int j = 0; j < columnNumber; j++){
                datacell = row.createCell(j);
                datacell.setCellValue(dataList[i][j]);
                datacell.setCellStyle(cellStyle);
            }
        }


        // 第五步，将文件存到指定位置
        String filePath = saveFile(wb,titleName);
        return filePath;
    }
    /**
     * 标题单元格样式
     * @param wb		HSSFWorkbook 对象
     * @param font		HSSFFont字体样式
     * @return
     */
    private static HSSFCellStyle getHeadCellStyle(HSSFWorkbook wb, HSSFFont font) {
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);

        if(font!=null) {
            style.setFont(font);
        }
        return style;
    }
    /**
     * 数据单元格样式
     * @param wb
     * @param font
     * @return
     */
    private static HSSFCellStyle getCellStyle(HSSFWorkbook wb, HSSFFont font) {
        HSSFCellStyle style = wb.createCellStyle();
        style.setWrapText(true);// 设置自动换行
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个上下居中格式
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        // 设置边框
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        if(font!=null) {
            style.setFont(font);
        }
        return style;
    }

    /**
     * 获得字体样式
     * @param wb HSSFWorkbook对象
     * @param bold		是否粗体
     * @param fontName	字体类型
     * @param fontSize	字体大小
     * @return
     */
    private static HSSFFont getFontStyle(HSSFWorkbook wb,boolean bold,String fontName,short fontSize) {
        HSSFFont headerFont = (HSSFFont) wb.createFont(); // 创建字体样式
        if(bold) {
            headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗
        }
        headerFont.setFontName(fontName); // 设置字体类型
        headerFont.setFontHeightInPoints(fontSize); // 设置字体大小
        return headerFont;
    }
    /**
     * 保存文件,返回文件的名字
     * @param wb
     * @param fileName
     * @return
     */
    private static String saveFile(HSSFWorkbook wb,String fileName) throws Exception {
        String filePath="";
        Date createtime = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        //  String path = "export" + File.separatorChar + formater.format(createtime);
        String path = "export";
        File targetFile = new File(PathUtil.getUploadPath() + File.separatorChar, path);
        //判断文件夹是否存在，不存在则创建
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        //文件存放路劲
        String fileStr = PathUtil.getUploadPath() + File.separatorChar + path + File.separatorChar +fileName;
        filePath = fileStr+ ".xls";

        File file=new File(filePath);
        int i=1;
        //判断文件是否存在，存在则文件名称加序号
        while(file.exists()) {
            filePath=fileStr+i+".xls";
            file=new File(filePath);
            i++;
        }
        FileOutputStream fout = new FileOutputStream(file);
        wb.write(fout);
        String str = "导出" + filePath + "成功！";
        logger.info(str);
        fout.close();
        return filePath;
    }


}
