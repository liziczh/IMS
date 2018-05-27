package com.liziczh.ims.service.impl;

import com.liziczh.ims.dao.IProductDao;
import com.liziczh.ims.dao.IRecordDao;
import com.liziczh.ims.dao.impl.ProductDaoImpl;
import com.liziczh.ims.dao.impl.RecordDaoImpl;
import com.liziczh.ims.domain.Product;
import com.liziczh.ims.service.IModifyService;

public class ModifyServiceImpl implements IModifyService {
    private IProductDao productDao = new ProductDaoImpl();
    private IRecordDao recordDao = new RecordDaoImpl();

    @Override
    public Product getProductById(int proId) {
        Product product = productDao.getProductById(proId);
        return product;
    }

    @Override
    public void modify(Product product) {
        productDao.updateProduct(product);
        recordDao.updateRecord(product.getProId(),product.getProName());
    }
}
