package com.liziczh.ims.service.impl;

import com.liziczh.ims.dao.IProductDao;
import com.liziczh.ims.dao.IRecordDao;
import com.liziczh.ims.dao.impl.ProductDaoImpl;
import com.liziczh.ims.dao.impl.RecordDaoImpl;
import com.liziczh.ims.domain.Product;
import com.liziczh.ims.service.IStockOutService;

import java.sql.SQLException;

public class StockOutServiceImpl implements IStockOutService {
    IProductDao productDao = new ProductDaoImpl();
    IRecordDao recordDao = new RecordDaoImpl();

    @Override
    public Product checkProduct(int id,int count) {
        try {
            if(productDao.getProductById(id) == null){
                return null;
            }else if(productDao.getProductById(id).getCount() < count){
                return null;
            }else{
                return productDao.getProductById(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void stockOut(int id, int count,String register,String recordType) {
        Product product = null;
        try {
            product = productDao.getProductById(id);
            recordDao.insertRecord(product,count,register,recordType);
            productDao.updateProductCountSub(product,count);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
