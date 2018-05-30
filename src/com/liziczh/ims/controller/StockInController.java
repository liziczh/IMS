package com.liziczh.ims.controller;

import com.liziczh.ims.dao.IRecordDao;
import com.liziczh.ims.domain.Product;
import com.liziczh.ims.domain.Record;
import com.liziczh.ims.service.IProductService;
import com.liziczh.ims.service.IRecordService;
import com.liziczh.ims.service.IStockInService;
import com.liziczh.ims.service.impl.ProductServiceImpl;
import com.liziczh.ims.service.impl.RecordServiceImpl;
import com.liziczh.ims.service.impl.StockInServiceImpl;
import com.liziczh.ims.views.AbstractStockInDialog;

import javax.swing.*;

public class StockInController extends AbstractStockInDialog {
    private IStockInService stockInService = new StockInServiceImpl();
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
            stockInService.stockIn(product,registerText.getText(),recordType);
            JOptionPane.showMessageDialog(this,"成功入库","温馨提示",JOptionPane.INFORMATION_MESSAGE);
            reset();
        }

    }

    @Override
    public void autoComplete() {
        if(proIdText.getText() != ""){
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
