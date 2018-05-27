package com.liziczh.ims.service.impl;

import com.liziczh.ims.dao.IProductDao;
import com.liziczh.ims.dao.IRecordDao;
import com.liziczh.ims.dao.impl.ProductDaoImpl;
import com.liziczh.ims.dao.impl.RecordDaoImpl;
import com.liziczh.ims.domain.Product;
import com.liziczh.ims.service.IPurchaseInService;

public class PurchaseInServiceImpl implements IPurchaseInService {
    IRecordDao recordDao = new RecordDaoImpl();
    IProductDao productDao = new ProductDaoImpl();

    @Override
    public void inStock(Product product, String register, String recordType) {
        recordDao.insertRecord(product,product.getCount(),register,recordType);
        if(productDao.getProductById(product.getProId()) != null){
            productDao.updateProductCountPlus(product);
        }else{
            productDao.insertProduct(product);
        }
    }
}
