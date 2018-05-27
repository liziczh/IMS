package com.liziczh.ims.controller;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.service.IModifyService;
import com.liziczh.ims.service.impl.ModifyServiceImpl;
import com.liziczh.ims.tools.ListTableModel;
import com.liziczh.ims.views.AbstractInventoryMngDialog;

import javax.swing.*;


public class InventoryMngController extends AbstractInventoryMngDialog {
    private IModifyService modifyService = new ModifyServiceImpl();

    @Override
    public void modify() {
        if(modifyService.getProductById(new Integer(proIdText.getText())) != null){
            Product product = new Product(new Integer(proIdText.getText()),proNameText.getText(),(String) dirBox.getSelectedItem(),supplierText.getText(),brandText.getText(),0);
            modifyService.modify(product);
            JOptionPane.showMessageDialog(this,"修改成功","温馨提示",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this,"商品不存在","温馨提示",JOptionPane.WARNING_MESSAGE);
        }

    }

}
