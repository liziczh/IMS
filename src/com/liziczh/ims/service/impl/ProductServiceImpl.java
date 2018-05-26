package com.liziczh.ims.service.impl;

import com.liziczh.ims.dao.IProductDao;
import com.liziczh.ims.dao.impl.ProductDaoImpl;
import com.liziczh.ims.domain.Product;
import com.liziczh.ims.service.IProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    private IProductDao productDao = new ProductDaoImpl();
    @Override
    public List<Product> queryProduct(String proName, int lowerCount, int upperCount, String dirName,int currentPage, int pageSize) {
        List<Product> proList = null;
        try {
            proList = productDao.getProductByCountAndDirName(proName,lowerCount,upperCount,dirName,currentPage,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public int getTotal(String proName, int lowerCount, int upperCount, String dirName) {
        int total = 0;
        try {
            total = productDao.getTotalByCountAndDirName(proName, lowerCount, upperCount, dirName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public List<Product> queryAll() {
        List<Product> proList = null;
        try {
            proList = productDao.getAllProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proList;
    }


}
