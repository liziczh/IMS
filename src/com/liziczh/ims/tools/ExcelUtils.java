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
     * @param file 文件信息
     * @return
     * @throws Exception
     */
    public static List<List<Object>> readExcel(File file){
        try {
            List<List<List<Object>>> wbList = new LinkedList<>();
            // 工作簿
            Workbook xwb = new XSSFWorkbook(new FileInputStream(file));
            // 表格
            Sheet sheet = null;
            // 行
            Row row = null;
            // 单元格
            String cell = null;
            // 表
            sheet = xwb.getSheetAt(0);
            List<List<Object>> sheetList = new LinkedList<>();
            for (int i = sheet.getFirstRowNum()+1; i < sheet.getPhysicalNumberOfRows(); i++) {
                // 行
                row = sheet.getRow(i);
                List<Object> rowList = new LinkedList<>();
                for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++) {
                    // 通过 row.getCell(j).toString() 获取单元格内容，
                    cell = row.getCell(j).toString();
                    rowList.add(cell);
                }
                sheetList.add(rowList);
            }
            return sheetList;
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
     * @param file 文件信息
     * @return
     * @throws Exception
     */
    public static <T> void writeExcel(List<T> list,Class T,String[] colNames, File file) {
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
        for(int c = 0 ; c < colNames.length ; c++){
            cell = row.createCell(c);
            cell.setCellValue(colNames[c]);
            cell.setCellStyle(headerStyle);
        }
        // 单元格样式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 表数据
        for(int r = 0 ; r < list.size(); r++){
            T t = list.get(r);
            Field[] fs = t.getClass().getDeclaredFields();
            row = sheet.createRow(r+1);
            for(int c = 0 ; c < fs.length ; c++){
                String cellValue = null;
                try {
                    fs[c].setAccessible(true);
                    if(fs[c].get(t) != null){
                        cellValue = fs[c].get(t).toString();
                    }else{
                        cellValue = "";
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                row.createCell(c).setCellValue(cellValue);
                row.createCell(c).setCellStyle(cellStyle);
            }
        }

        workbook.setSheetName(0, T.getName());

        try {
            FileOutputStream fileoutputStream = new FileOutputStream(file);
            workbook.write(fileoutputStream);
            fileoutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
