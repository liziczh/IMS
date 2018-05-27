package com.liziczh.ims.controller;

import com.liziczh.ims.service.IStockOutService;
import com.liziczh.ims.service.impl.StockOutServiceImpl;
import com.liziczh.ims.views.AbstractStockOutDialog;

import javax.swing.*;

public class StockOutController extends AbstractStockOutDialog {
    private IStockOutService stockOutService = new StockOutServiceImpl();

    @Override
    public void reset() {
        proIdText.setText("");
        proNameText.setText("");
        countText.setText("");
        registerText.setText("");
    }

    @Override
    public void stockOut() {
        if(stockOutService.checkProduct(new Integer(proIdText.getText()),new Integer(countText.getText())) == null){
            JOptionPane.showMessageDialog(this,"商品不存在或库存不足，无法出库","温馨提示",JOptionPane.WARNING_MESSAGE);
        }else{
            stockOutService.stockOut(new Integer(proIdText.getText()),new Integer(countText.getText()),registerText.getText(),recordType);
            JOptionPane.showMessageDialog(this,"成功出库","温馨提示",JOptionPane.INFORMATION_MESSAGE);
            reset();
        }

    }

}
