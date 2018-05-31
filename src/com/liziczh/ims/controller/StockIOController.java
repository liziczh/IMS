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
        if(proIdText.getText() == null && proNameText.getText() == null && dirBox.getSelectedItem() == "全部" && supplierText == null && brandText == null && countText == null && registerText == null){
            JOptionPane.showMessageDialog(this,"请确认所有选项都已填写完成","温馨提示",JOptionPane.INFORMATION_MESSAGE);
        }else{
            Product product = new Product(new Integer(proIdText.getText()),proNameText.getText(), (String) dirBox.getSelectedItem(),supplierText.getText(),brandText.getText(),new Integer(countText.getText()));
            stockIOService.stockIn(product,registerText.getText(),recordType);
            JOptionPane.showMessageDialog(this,"成功入库","温馨提示",JOptionPane.INFORMATION_MESSAGE);
            reset();
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

    @Override
    public void stockOut() {
        if(stockIOService.checkProduct(new Integer(proIdText.getText()),new Integer(countText.getText())) == null){
            JOptionPane.showMessageDialog(this,"商品不存在或库存不足，无法出库","温馨提示",JOptionPane.WARNING_MESSAGE);
        }else{
            stockIOService.stockOut(new Integer(proIdText.getText()),new Integer(countText.getText()),registerText.getText(),recordType);
            JOptionPane.showMessageDialog(this,"成功出库","温馨提示",JOptionPane.INFORMATION_MESSAGE);
            reset();
        }
    }

}
