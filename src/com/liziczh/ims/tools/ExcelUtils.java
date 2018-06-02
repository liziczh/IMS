package com.liziczh.ims.tools;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
    public static List<List<List<Object>>> readExcel(File file){
        try {
            if(!file.exists()){
                throw new Exception("找不到文件");
            }
            List<List<List<Object>>> wbList = new LinkedList<>();
            // 工作簿
            Workbook xwb = new XSSFWorkbook(new FileInputStream(file));
            // 表格
            Sheet sheet = null;
            // 行
            Row row = null;
            // 单元格
            String cell = null;
            for(int s = xwb.getFirstVisibleTab(); s < xwb.getNumberOfSheets(); s++){
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
                    System.out.println(sheetList);
                }
                wbList.add(sheetList);
            }
            return wbList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public static <T> void write(List<T> list, File file) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("0");
        Row row = sheet.createRow(0);
        CellStyle cellStyle = workbook.createCellStyle();

        for(int r = 0 ; r < list.size(); r++){
            row.createCell(0).setCellValue("姓名");
            row.createCell(1).setCellValue("年龄");
        }



        workbook.setSheetName(0, "信息");

        try {
            FileOutputStream fileoutputStream = new FileOutputStream(file);
            workbook.write(fileoutputStream);
            fileoutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        List list = new ArrayList();
        write(list,new File("C:\\Users\\lizic\\Desktop\\POI3.xlsx"));
//        readExcel(new File("C:\\Users\\lizic\\Desktop\\201505暑期留宿情况.xlsx"));
    }



}
