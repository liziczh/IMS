package com.liziczh.ims.controller;

import com.liziczh.ims.domain.Record;
import com.liziczh.ims.service.IRecordService;
import com.liziczh.ims.service.impl.RecordServiceImpl;
import com.liziczh.ims.tools.ListTableModel;
import com.liziczh.ims.views.AbstractRecordPanel;

import java.util.List;


public class RecordController extends AbstractRecordPanel {
    private IRecordService recordService = new RecordServiceImpl();
    @Override
    public void queryRecord() {
        String beginDate = this.beginDateText.getText();
        String endDate = this.endDateText.getText();
        String dirName = (String) this.dir.getSelectedItem();
        recordList = recordService.queryRecord(beginDate,endDate,recordType,dirName);
        try {
            recordTable.setModel(new ListTableModel<Record>(recordList,Record.class,colNames,propNames));
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for(int row = 0 ; row < recordList.size() ; row++){
//            for(Record r : recordList){
//                data[row][0] = r.getDate();
//                data[row][1] = r.getProId();
//                data[row][2] = r.getProName();
//                data[row][3] = r.getCount();
//                data[row][4] = r.getRegister();
//            }
//        }

    }





}
