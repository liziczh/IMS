package com.liziczh.ims.controller;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.service.IModifyService;
import com.liziczh.ims.service.impl.ModifyServiceImpl;
import com.liziczh.ims.views.AbstractInventoryMngDialog;

import javax.swing.*;

public class InventoryMngController extends AbstractInventoryMngDialog {
    private IModifyService modifyService = new ModifyServiceImpl();

    @Override
    public void reset() {
        this.setText(this.product);
    }

    @Override
    public void modify() {
        if(proIdText.getText() != null && proNameText.getText() != null && !"全部".equals((String) dirBox.getSelectedItem()) && supplierText.getText() != null && brandText.getText() != null){
            if(!"".equals(proIdText.getText()) && !"".equals(proNameText.getText()) && !"全部".equals((String) dirBox.getSelectedItem()) && !"".equals(supplierText.getText()) && !"".equals(brandText.getText())) {
                if (proIdText.getText().matches("[0-9A-Za-z]+")) {
                    Product product = new Product(new Integer(proIdText.getText()), proNameText.getText(), (String) dirBox.getSelectedItem(), supplierText.getText(), brandText.getText(), 0);
                    modifyService.modify(product);
                    JOptionPane.showMessageDialog(this, "修改成功", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "商品编号输入有误", "温馨提示", JOptionPane.WARNING_MESSAGE);
                }
            } else{
                JOptionPane.showMessageDialog(this,"请确认所有选项都已填写完成","温馨提示",JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this,"请确认所有选项都已填写完成","温馨提示",JOptionPane.WARNING_MESSAGE);
        }
    }

}
