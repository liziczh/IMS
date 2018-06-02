package com.liziczh.ims.service.impl;

import com.liziczh.ims.dao.IProductDao;
import com.liziczh.ims.dao.IRecordDao;
import com.liziczh.ims.dao.impl.ProductDaoImpl;
import com.liziczh.ims.dao.impl.RecordDaoImpl;
import com.liziczh.ims.domain.Product;
import com.liziczh.ims.service.IModifyService;

import java.sql.SQLException;

public class ModifyServiceImpl implements IModifyService {
    private IProductDao productDao = new ProductDaoImpl();
    private IRecordDao recordDao = new RecordDaoImpl();

    @Override
    public Product getProductById(int proId) {
        Product product = null;
        try {
            product = productDao.getProductById(proId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void modify(Product product) {
        try {
            productDao.updateProduct(product);
            recordDao.updateRecord(product.getProId(),product.getProName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
