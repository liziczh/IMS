package com.liziczh.ims.controller;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.service.IPurchaseInService;
import com.liziczh.ims.service.impl.PurchaseInServiceImpl;
import com.liziczh.ims.views.AbstractPurchaseInPanel;

import javax.swing.*;

public class PurchaseInController extends AbstractPurchaseInPanel {
    private IPurchaseInService purchaseInService = new PurchaseInServiceImpl();
    @Override
    public void reset() {
        proIdText.setText("");
        proNameText.setText("");
        dirBox.setSelectedIndex(0);
        supplierText.setText("");
        brandText.setText("");
        countText.setText("");
        registerText.setText("");
    }
    @Override
    public void inStock() {
        if(proIdText.getText() == null && proNameText.getText() == null && dirBox.getSelectedItem() == "全部" && supplierText == null && brandText == null && countText == null && registerText == null){
            JOptionPane.showMessageDialog(null,"请确认所有选项都已填写完成");
        }else{
            Product product = new Product(new Integer(proIdText.getText()),proNameText.getText(), (String) dirBox.getSelectedItem(),supplierText.getText(),brandText.getText(),new Integer(countText.getText()));
            purchaseInService.inStock(product,registerText.getText(),recordType);
            JOptionPane.showMessageDialog(this,"成功入库","温馨提示",JOptionPane.INFORMATION_MESSAGE);
            reset();
        }

    }

}
