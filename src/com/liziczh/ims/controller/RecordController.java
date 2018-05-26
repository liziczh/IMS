package com.liziczh.ims.controller;

import com.liziczh.ims.domain.Record;
import com.liziczh.ims.service.IRecordService;
import com.liziczh.ims.service.impl.RecordServiceImpl;
import com.liziczh.ims.tools.ListTableModel;
import com.liziczh.ims.views.AbstractRecordPanel;


public class RecordController extends AbstractRecordPanel {
    private IRecordService recordService = new RecordServiceImpl();
    // 总记录数
    int total = recordService.getTotal(beginDateText.getText(),endDateText.getText(),recordType,(String) dirBox.getSelectedItem());
    @Override
    public void queryRecord() {
        recordList = recordService.queryRecord(beginDateText.getText(),endDateText.getText(),recordType,(String)dirBox.getSelectedItem(),currentPage,pageSize);
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
    }

    @Override
    public void prevPage() {
        if(currentPage != 1){
            currentPage--;
            queryRecord();
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
        }
    }


}
