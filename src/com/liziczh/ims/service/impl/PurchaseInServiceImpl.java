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
    public void commitData(Product product, String register,String in) {
        recordDao.insertInStock(product,register,in);
        if(productDao.getProductById(product.getProId()) != null){
            recordDao.updateProduct(product);
        }else{
            recordDao.insertProduct(product);
        }
    }
}
