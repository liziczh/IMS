package com.liziczh.ims.controller;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.service.IProductService;
import com.liziczh.ims.service.impl.ProductServiceImpl;
import com.liziczh.ims.tools.ListTableModel;
import com.liziczh.ims.views.AbstractInventoryQueryPanel;

import javax.swing.*;

public class InventoryQueryController extends AbstractInventoryQueryPanel {
    private IProductService productService = new ProductServiceImpl();
    // 库存上下限默认值
    private int lowerCount = 0;
    private int upperCount = 99999;
    // 总记录数
    int total = productService.getTotal(proNameText.getText(),lowerCount,upperCount,(String) dirBox.getSelectedItem());
    @Override
    public void queryProduct() {
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
        // 结果集
        proList = productService.queryProduct(proNameText.getText(),lowerCount,upperCount, (String) dirBox.getSelectedItem(),currentPage,pageSize);
        try {
            stockTable.setModel(new ListTableModel<>(proList,Product.class,colNames,propNames));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void homePage() {
        currentPage = 1;
        queryProduct();
    }

    @Override
    public void prevPage() {
        if(currentPage != 1){
            currentPage--;
            queryProduct();
        }
    }

    @Override
    public void nextPage() {
        int endPage;
        if(total != 0){
            if(total % pageSize == 0){
                endPage = total/pageSize;
            }else{
                endPage = total/pageSize + 1;
            }
            if(currentPage != endPage){
                currentPage ++;
                queryProduct();
            }
        }
    }

    @Override
    public void endPage() {
        if(total != 0){
            if(total % pageSize == 0){
                currentPage = total/pageSize;
            }else{
                currentPage = total/pageSize + 1;
            }
            queryProduct();
        }
    }

}
