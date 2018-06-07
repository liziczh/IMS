package com.liziczh.ims.tools;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public class ExcelUtils {
    /**
     * 针对xlsx文件，要求excel版本在2007以上
     *
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
                for (int i = sheet.getFirstRowNum()+1; i < sheet.getPhysicalNumberOfRows(); i++) {
                    // 行
                    row = sheet.getRow(i);
                    T t = (T) T.newInstance();
                    for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++) {
                        // 通过 row.getCell(j).toString() 获取单元格内容，
                        cell = row.getCell(j);
                        Field[] fs = t.getClass().getDeclaredFields();
                        fs[j].setAccessible(true);
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
     * 针对xlsx文件，要求excel版本在2007以上
     *
     * @param list 数据
     * @param T 泛型类
     * @param colNames 表头信息,
     * @param filepath 文件路径
     * @return
     * @throws Exception
     */
    public static <T> void writeExcel(List<T> list,Class T,String[] colNames,String filepath) {
        if(filepath != null && !"".equals(filepath)){
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("0");
            Row row = null;
            Cell cell = null;
            // 表头样式
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);
            // 表头
            row = sheet.createRow(0);
            for (int c = 0; c < colNames.length; c++) {
                cell = row.createCell(c);
                cell.setCellValue(colNames[c]);
                cell.setCellStyle(headerStyle);
            }
            // 单元格样式
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            // 表数据
            for (int r = 0; r < list.size(); r++) {
                T t = list.get(r);
                Field[] fs = t.getClass().getDeclaredFields();
                row = sheet.createRow(r + 1);
                for (int j = 0; j < fs.length; j++) {
                    try {
                        fs[j].setAccessible(true);
                        cell = row.createCell(j);
                        cell.setCellValue(String.valueOf(fs[j].get(t)));
                        cell.setCellStyle(cellStyle);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

            workbook.setSheetName(0, T.getName());

            try {
                FileOutputStream fileoutputStream = new FileOutputStream(new File(filepath));
                workbook.write(fileoutputStream);
                fileoutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
