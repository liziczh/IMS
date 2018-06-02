package com.liziczh.ims.service.impl;

import com.liziczh.ims.dao.IProductDao;
import com.liziczh.ims.dao.IRecordDao;
import com.liziczh.ims.dao.impl.ProductDaoImpl;
import com.liziczh.ims.dao.impl.RecordDaoImpl;
import com.liziczh.ims.domain.Product;
import com.liziczh.ims.service.IStockIOService;

import java.sql.SQLException;

public class StockIOServiceImpl implements IStockIOService {
    private IRecordDao recordDao = new RecordDaoImpl();
    private IProductDao productDao = new ProductDaoImpl();

    @Override
    public void stockIn(Product product, String register, String recordType) {
        try {
            recordDao.insertRecord(product,product.getCount(),register,recordType);
            if(productDao.getProductById(product.getProId()) != null){
                productDao.updateProductCountPlus(product);
            }else{
                productDao.insertProduct(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
        Product product;
        try {
            product = productDao.getProductById(id);
            recordDao.insertRecord(product,count,register,recordType);
            productDao.updateProductCountSub(product,count);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
