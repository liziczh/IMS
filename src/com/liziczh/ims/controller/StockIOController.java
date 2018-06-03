package com.liziczh.ims.controller;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.service.IProductService;
import com.liziczh.ims.service.IStockIOService;
import com.liziczh.ims.service.impl.ProductServiceImpl;
import com.liziczh.ims.service.impl.StockIOServiceImpl;
import com.liziczh.ims.views.AbstractStockIODialog;

import javax.swing.*;

public class StockIOController extends AbstractStockIODialog {
    private IStockIOService stockIOService = new StockIOServiceImpl();
    private IProductService productService = new ProductServiceImpl();
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
    public void stockIn() {
        if(proIdText.getText() != null && proNameText.getText() != null && dirBox.getSelectedItem() != "全部" && supplierText != null && brandText != null && countText != null && registerText != null){
            if(proIdText.getText().matches("[0-9A-Za-z]+")){
                if(countText.getText().matches("[0-9]+")){
                    Product product = new Product(new Integer(proIdText.getText()),proNameText.getText(), (String) dirBox.getSelectedItem(),supplierText.getText(),brandText.getText(),new Integer(countText.getText()));
                    stockIOService.stockIn(product,registerText.getText(),recordType);
                    JOptionPane.showMessageDialog(this,"成功入库","温馨提示",JOptionPane.WARNING_MESSAGE);
                    reset();
                }else{
                    JOptionPane.showMessageDialog(this,"商品数量输入有误","温馨提示",JOptionPane.WARNING_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this,"商品编号输入有误","温馨提示",JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this,"请确认所有选项都已填写完成","温馨提示",JOptionPane.WARNING_MESSAGE);
        }

    }

    @Override
    public void stockOut() {
        if(proIdText.getText() != null && proNameText.getText() != null && !"全部".equals(dirBox.getSelectedItem()) && supplierText.getText() != null && brandText.getText() != null && countText.getText() != null && registerText.getText() != null) {
            if (!"".equals(proIdText.getText()) && !"".equals(proNameText.getText()) && !"全部".equals(dirBox.getSelectedItem()) && !"".equals(supplierText.getText()) && !"".equals(brandText.getText()) && !"".equals(brandText.getText()) && !"".equals(registerText.getText())) {
                if (proIdText.getText().matches("[0-9]+")) {
                    if (countText.getText().matches("[0-9]+")) {
                        if (stockIOService.checkProduct(new Integer(proIdText.getText()), new Integer(countText.getText())) == null) {
                            JOptionPane.showMessageDialog(this, "商品不存在或库存不足，无法出库", "温馨提示", JOptionPane.WARNING_MESSAGE);
                        } else {
                            stockIOService.stockOut(new Integer(proIdText.getText()), new Integer(countText.getText()), registerText.getText(), recordType);
                            JOptionPane.showMessageDialog(this, "成功出库", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
                            reset();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "商品数量输入有误", "温馨提示", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "商品编号输入有误", "温馨提示", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,"请确认所有选项都已填写完成","温馨提示",JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this,"请确认所有选项都已填写完成","温馨提示",JOptionPane.WARNING_MESSAGE);
        }

    }

    @Override
    public void autoComplete() {
        if(!"".equals(proIdText.getText())){
            Product product = productService.queryProductById(Integer.parseInt(proIdText.getText()));
            if(product != null){
                proNameText.setText(product.getProName());
                dirBox.setSelectedItem(product.getDirName());
                supplierText.setText(product.getSupplier());
                brandText.setText(product.getBrand());
            }else{
                proNameText.setText("");
                dirBox.setSelectedItem("");
                supplierText.setText("");
                brandText.setText("");
            }
        }
    }


}
