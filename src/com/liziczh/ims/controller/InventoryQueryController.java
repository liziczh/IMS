package com.liziczh.ims.controller;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.service.IProductService;
import com.liziczh.ims.service.impl.ProductServiceImpl;
import com.liziczh.ims.tools.ListTableModel;
import com.liziczh.ims.views.AbstractInventoryQueryPanel;

import javax.swing.*;

public class InventoryQueryController extends AbstractInventoryQueryPanel {
    private IProductService productService = new ProductServiceImpl();
    @Override
    public void queryRecord() {
        // 产品名称
        String proName = this.proNameText.getText();
        // 库存上下限
        int lowerCount = 0;
        int upperCount = 99999;
        // 判断库存下限值输入是否合法
        if("".equals(countLowerText.getText())){
            lowerCount = 0;
        }else if(countLowerText.getText().matches("[0-9]+")){
            lowerCount = Integer.valueOf(countLowerText.getText());
        }else{
            JOptionPane.showMessageDialog(this,"库存量下限输入有误","温馨提示",JOptionPane.WARNING_MESSAGE);
        }
        // 判断库存上限值输入是否合法
        if("".equals(countUpperText.getText())){
            upperCount = 99999;
        }else if(countUpperText.getText().matches("[0-9]+")){
            upperCount = Integer.valueOf(countUpperText.getText());
        }else{
            JOptionPane.showMessageDialog(this,"库存量上限输入有误","温馨提示",JOptionPane.WARNING_MESSAGE);
        }
        // 分类
        String dirName = (String) this.dirBox.getSelectedItem();
        proList = productService.queryProduct(proName,lowerCount,upperCount,dirName);
        try {
            stockTable.setModel(new ListTableModel<Product>(proList,Product.class,colNames,propNames));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
