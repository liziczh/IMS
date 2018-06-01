package com.liziczh.ims.controller;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.tools.ListTableModel;
import com.liziczh.ims.views.AbstractInventoryMngDialog;
import com.liziczh.ims.views.AbstractMainFrame;

import javax.swing.*;

public class MainController extends AbstractMainFrame {
    public MainController(String username) {
        super(username);
    }

    @Override
    public void exit() {
        this.dispose();
        new LoginController();
    }

    @Override
    public void inventoryMng() {
        Product product = null;
        try {
            if(inventoryPanel.stockTable.getSelectedRow() == -1 && product == null){
                JOptionPane.showMessageDialog(null,"未选中任何商品","温馨提示",JOptionPane.WARNING_MESSAGE);
            }else {
                product = new ListTableModel<>(inventoryPanel.proList,Product.class,inventoryPanel.colNames,inventoryPanel.propNames).getInstance(inventoryPanel.stockTable.getSelectedRow());
                if(product == null){
                    JOptionPane.showMessageDialog(null,"未选中任何商品","温馨提示",JOptionPane.WARNING_MESSAGE);
                }else{
                    AbstractInventoryMngDialog inventoryMngDialog = new InventoryMngController();
                    inventoryMngDialog.product = product;
                    inventoryMngDialog.setText(product);
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
