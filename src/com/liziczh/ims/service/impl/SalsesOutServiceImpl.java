package com.liziczh.ims.service.impl;

import com.liziczh.ims.dao.IProductDao;
import com.liziczh.ims.dao.IRecordDao;
import com.liziczh.ims.dao.impl.ProductDaoImpl;
import com.liziczh.ims.dao.impl.RecordDaoImpl;
import com.liziczh.ims.domain.Product;
import com.liziczh.ims.service.ISalesOutService;

public class SalsesOutServiceImpl implements ISalesOutService {
    IProductDao productDao = new ProductDaoImpl();
    IRecordDao recordDao = new RecordDaoImpl();
    @Override
    public Product QueryProduct(int id,int count) {
        if(productDao.getProductById(id) == null){
            return null;
        }else if(productDao.getProductById(id).getCount() < count){
            return null;
        }else{
            return productDao.getProductById(id);
        }
    }
    @Override
    public void outStock(int id, int count,String register,String recordType) {
        Product product = productDao.getProductById(id);
        recordDao.insertOutStock(product,count,register,recordType);
        recordDao.stockOut(product,count);
    }
}
