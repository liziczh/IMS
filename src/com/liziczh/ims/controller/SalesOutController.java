package com.liziczh.ims.controller;

import com.liziczh.ims.service.ISalesOutService;
import com.liziczh.ims.service.impl.SalsesOutServiceImpl;
import com.liziczh.ims.views.AbstractSalesOutPanel;

import javax.swing.*;

public class SalesOutController extends AbstractSalesOutPanel {
    private ISalesOutService service = new SalsesOutServiceImpl();
    public void reset() {
        proIdText.setText("");
        proNameText.setText("");
        countText.setText("");
        registerText.setText("");
    }

    public void delete() {

        if(service.QueryProduct(new Integer(proIdText.getText()),new Integer(countText.getText())) == null){
            JOptionPane.showMessageDialog(this,"商品不存在或库存不足，无法完成商品出库","温馨提示",JOptionPane.WARNING_MESSAGE);
        }else{
            recordType = "out";
            service.outStock(new Integer(proIdText.getText()),new Integer(countText.getText()),registerText.getText(),recordType);
            JOptionPane.showMessageDialog(this,"成功出库","温馨提示",JOptionPane.INFORMATION_MESSAGE);
            reset();
        }
    }

}
