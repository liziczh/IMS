package com.liziczh.ims.controller;

import com.liziczh.ims.domain.Record;
import com.liziczh.ims.service.IRecordService;
import com.liziczh.ims.service.impl.RecordServiceImpl;
import com.liziczh.ims.tools.ExcelUtils;
import com.liziczh.ims.tools.ListTableModel;
import com.liziczh.ims.views.AbstractRecordPanel;

import javax.swing.*;
import java.io.File;
import java.util.List;


public class RecordController extends AbstractRecordPanel {
    private IRecordService recordService = new RecordServiceImpl();

    @Override
    public void queryRecord() {
        recordList = recordService.queryRecord(beginDateText.getText(),endDateText.getText(),proNameText.getText(),this.recordType,(String)dirBox.getSelectedItem(),currentPage,pageSize);
        total = recordService.getTotal(beginDateText.getText(),endDateText.getText(),proNameText.getText(),recordType,(String) dirBox.getSelectedItem());
        try {
            recordTable.setModel(new ListTableModel<Record>(recordList,Record.class,colNames,propNames));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void homePage() {
        currentPage = 1;
        queryRecord();
        pageNumText.setText(String.valueOf(currentPage));
    }

    @Override
    public void prevPage() {
        if(currentPage != 1){
            currentPage--;
            queryRecord();
            pageNumText.setText(String.valueOf(currentPage));
        }
    }

    @Override
    public void nextPage() {
        int endPage;
        if(total != 0){
            if(total % pageSize == 0){
                endPage = total/pageSize;
            }else{
                endPage = total/pageSize + 1;
            }
            if(currentPage != endPage){
                currentPage ++;
                queryRecord();
                pageNumText.setText(String.valueOf(currentPage));
            }
        }
    }

    @Override
    public void endPage() {
        if(total != 0){
            if(total % pageSize == 0){
                currentPage = total/pageSize;
            }else{
                currentPage = total/pageSize + 1;
            }
            queryRecord();
            pageNumText.setText(String.valueOf(currentPage));
        }
    }

    @Override
    public void jumpPage() {
        int endPage;
        if(total % pageSize == 0){
            endPage = total/pageSize;
        }else{
            endPage = total/pageSize + 1;
        }
        if(Integer.parseInt(pageNumText.getText()) < endPage){
            currentPage = Integer.parseInt(pageNumText.getText());
            queryRecord();
        }else{
            currentPage = endPage;
            pageNumText.setText(String.valueOf(currentPage));
            queryRecord();
        }
    }

    @Override
    public void exportRecord() {
        List<Record> proList =  recordService.queryAllRecord(beginDateText.getText(),endDateText.getText(),proNameText.getText(),this.recordType,(String)dirBox.getSelectedItem());
        ExcelUtils.writeExcel(proList,Record.class,colNames,new File("data/Stock"+recordType+"Record.xlsx"));
        JOptionPane.showMessageDialog(this,"导出成功，请前往IMS/data/Stock"+recordType+"Record.xlsx查看","温馨提示",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void importRecord() {
        List<Record> recordList = ExcelUtils.readExcel(Record.class,new File("data/Stock"+recordType+"Record.xlsx"));
        int n = JOptionPane.showConfirmDialog(null, "是否清空已有数据", "请确认",JOptionPane.YES_NO_OPTION);
        if(n == 0){
            recordService.clear(recordType);
            for(Record record : recordList) {
                if(record != null){
                    recordService.insertRecord(record);
                }else{
                    JOptionPane.showMessageDialog(this,"表内没有数据","温馨提示",JOptionPane.WARNING_MESSAGE);
                }
            }
        }else{
            recordService.clear(recordType);
            for(Record record : recordList) {
                if(record != null){
                    recordService.insertRecord(record);
                }else{
                    JOptionPane.showMessageDialog(this,"表内没有数据","温馨提示",JOptionPane.WARNING_MESSAGE);
                }
            }
        }

    }

}
