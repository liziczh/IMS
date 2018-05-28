package com.liziczh.ims.controller;

import com.liziczh.ims.service.ILedgerService;
import com.liziczh.ims.service.impl.LedgerServiceImpl;
import com.liziczh.ims.views.StatisticsChartDialog;
import com.liziczh.ims.views.StatisticsPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StatisticsController extends StatisticsPanel {

    ILedgerService service = new LedgerServiceImpl();
    @Override
    public void count() {
        if(((String)dirBox.getSelectedItem()).equals("采购")){
            recordType = "in";
        }else if(((String)dirBox.getSelectedItem()).equals("销售")){
            recordType = "out";
        }
        service.creatPie(recordType,beginDateText.getText(),endDateText.getText());
        new StatisticsChartDialog(recordType).setVisible(true);
    }
}
