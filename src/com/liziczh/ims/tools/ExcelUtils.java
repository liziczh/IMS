package com.liziczh.ims.tools;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/**
 * Excel文件读写工具类：针对一行数据(row)作为一个实例(t)的情况
 */
public class ExcelUtils {
    /**
     * 针对xlsx文件，使用XSSFWorkbook，要求excel版本在2007以上
     *
     * @param T 泛型类，行对象
     * @param filepath 文件路径
     * @return
     * @throws Exception
     */
    public static <T> List<T> readExcel(Class T,String filepath){
        try {
            if(filepath != null && !"".equals(filepath)){
                // 工作簿
                Workbook xwb = new XSSFWorkbook(new FileInputStream(filepath));
                // 表格
                Sheet sheet = null;
                // 行
                Row row = null;
                // 单元格
                Cell cell = null;
                // 表
                sheet = xwb.getSheetAt(0);
                List<T> sheetList = new LinkedList<>();
                for(int i = sheet.getFirstRowNum()+1; i < sheet.getPhysicalNumberOfRows(); i++){
                    // 获取第i行
                    row = sheet.getRow(i);
                    // 利用反射生成一个实例
                    T t = (T) T.newInstance();
                    // 依此获取单元格放入对象t中
                    for(int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++){
                        // 获取第i行第j列的单元格，
                        cell = row.getCell(j);
                        // 获取对象的属性数组
                        Field[] fs = t.getClass().getDeclaredFields();
                        // 设置属性为可访问
                        fs[j].setAccessible(true);
                        // 类型转换：将单元格内容先转为String再转为当前属性所对应的类型
                        if(fs[j].getType() == String.class){
                            fs[j].set(t,fs[j].getType().cast(cell.toString()));
                        } else if (fs[j].getType() == int.class) {
                            fs[j].set(t,new Integer(cell.toString()));
                        } else if(fs[j].getType() == short.class){
                            fs[j].set(t,new Short(cell.toString()));
                        }else if(fs[j].getType() == long.class){
                            fs[j].set(t,new Long(cell.toString()));
                        }else if(fs[j].getType() == byte.class){
                            fs[j].set(t,new Byte(cell.toString()));
                        }else if(fs[j].getType() == float.class){
                            fs[j].set(t,new Float(cell.toString()));
                        }else if(fs[j].getType() == double.class){
                            fs[j].set(t,new Double(cell.toString()));
                        }
                    }
                    // 将对象t添加到集合中
                    sheetList.add(t);
                }
                return sheetList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 针对xlsx文件，使用XSSFWorkbook，要求excel版本在2007以上
     *
     * @param list 数据
     * @param T 泛型类，行对象
     * @param colNames 表头信息,
     * @param filepath 文件路径
     * @return
     * @throws Exception
     */
    public static <T> void writeExcel(List<T> list,Class T,String[] colNames,String filepath) {
        if(filepath != null && !"".equals(filepath)){
            // 工作簿
            Workbook workbook = new XSSFWorkbook();
            // 表格
            Sheet sheet = workbook.createSheet("0");
            // 行
            Row row = null;
            // 单元格
            Cell cell = null;
            // 设置表头样式
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);
            // 通过colNames数组生成表头
            row = sheet.createRow(0);
            for (int c = 0; c < colNames.length; c++) {
                cell = row.createCell(c);
                cell.setCellValue(colNames[c]);
                cell.setCellStyle(headerStyle);
            }
            // 设置单元格样式
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            // 通过一个List生成表内数据
            for (int r = 0; r < list.size(); r++) {
                // 获取一个List元素（即一个T的实例）
                T t = list.get(r);
                // 获取对象t的所有属性
                Field[] fs = t.getClass().getDeclaredFields();
                // 生成行
                row = sheet.createRow(r + 1);
                // 依此获取对象t的属性值 赋予 单元格
                for (int j = 0; j < fs.length; j++) {
                    try {
                        // 设置属性为可访问
                        fs[j].setAccessible(true);
                        // 生成一个单元格
                        cell = row.createCell(j);
                        // 将属性值赋予单元格
                        cell.setCellValue(String.valueOf(fs[j].get(t)));
                        cell.setCellStyle(cellStyle);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            // 设置表名
            workbook.setSheetName(0, T.getName());
            // 生成xlsx文件
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(new File(filepath));
                workbook.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
