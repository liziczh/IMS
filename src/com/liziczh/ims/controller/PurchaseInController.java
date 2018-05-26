package com.liziczh.ims.controller;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.service.IPurchaseInService;
import com.liziczh.ims.service.impl.PurchaseInServiceImpl;
import com.liziczh.ims.views.AbstractPurchaseInPanel;

import javax.swing.*;

public class PurchaseInController extends AbstractPurchaseInPanel {
    private IPurchaseInService service = new PurchaseInServiceImpl();
    public void reset() {
        proIdText.setText("");
        proNameText.setText("");
        dirNameText.setText("");
        supplierText.setText("");
        brandText.setText("");
        countText.setText("");
        registerText.setText("");
    }

    public void commit() {
        Product product = new Product(new Integer(proIdText.getText()),proNameText.getText(),dirNameText.getText(),supplierText.getText(),brandText.getText(),new Integer(countText.getText()));
        String register = registerText.getText();
        recordType = "in";
        service.commitData(product,register,recordType);
        JOptionPane.showMessageDialog(this,"成功入库","温馨提示",JOptionPane.INFORMATION_MESSAGE);
        reset();
    }

}
