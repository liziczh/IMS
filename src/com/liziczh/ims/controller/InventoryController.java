package com.liziczh.ims.controller;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.service.IProductService;
import com.liziczh.ims.service.impl.ProductServiceImpl;
import com.liziczh.ims.tools.ChooserUtils;
import com.liziczh.ims.tools.ExcelUtils;
import com.liziczh.ims.tools.ListTableModel;
import com.liziczh.ims.views.AbstractInventoryPanel;

import javax.swing.*;
import java.io.File;
import java.util.List;

public class InventoryController extends AbstractInventoryPanel {
    private IProductService productService = new ProductServiceImpl();
    // 库存上下限默认值
    private int lowerCount = 0;
    private int upperCount = 99999;

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
        // 总记录数
        total = productService.getTotal(proNameText.getText(),lowerCount,upperCount,(String) dirBox.getSelectedItem());
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
        pageNumText.setText(String.valueOf(currentPage));
    }

    @Override
    public void prevPage() {
        if(currentPage != 1){
            currentPage--;
            queryProduct();
            pageNumText.setText(String.valueOf(currentPage));
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
                pageNumText.setText(String.valueOf(currentPage));
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
            pageNumText.setText(String.valueOf(currentPage));
        }
    }

    @Override
    public void jumpPage() {
        int endPage;
        if(total % pageSize == 0){
            endPage = total/pageSize;
        }else{
            endPage = total/pageSize + 1;
        }
        if(Integer.parseInt(pageNumText.getText()) < endPage){
            currentPage = Integer.parseInt(pageNumText.getText());
            queryProduct();
        }else{
            currentPage = endPage;
            pageNumText.setText(String.valueOf(currentPage));
            queryProduct();
        }
    }

    @Override
    public void exportProduct() {
        List<Product> proList = productService.queryAllProduct(proNameText.getText(),lowerCount,upperCount, (String) dirBox.getSelectedItem());
        // 如果文件夹路径不为null
        String dirPath =  ChooserUtils.chooserDir(exportBtn);
        if(dirPath != null){
            ExcelUtils.writeExcel(proList,Product.class,colNames,dirPath+"/Product.xlsx");
            JOptionPane.showMessageDialog(this,"导出成功","温馨提示",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void importProduct() {
        int n = JOptionPane.showConfirmDialog(null, "是否清空已有数据", "请确认",JOptionPane.YES_NO_OPTION);
        if(n == 0){
            productService.clear();
        }
        String filePath = ChooserUtils.chooserFile(importBtn);
        if(filePath != null){
            List<Product> proList = ExcelUtils.readExcel(Product.class,filePath);
            for(Product product : proList){
                if(productService.queryProductById(product.getProId()) == null){
                    productService.insertProduct(product);
                }
            }
            JOptionPane.showMessageDialog(this,"导入成功","温馨提示",JOptionPane.INFORMATION_MESSAGE);
        }
    }


}
