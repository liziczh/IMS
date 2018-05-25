package com.liziczh.ims.dao;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.domain.ProductDir;

import java.sql.SQLException;
import java.util.List;

public interface IProductDirDao {
    // 根据id查询
    public ProductDir getProductDirById(int id) throws SQLException;
    // 查询所有分类
    public List<ProductDir> getAllProductDir() throws SQLException;
    // 插入数据
    public void insertProduct(ProductDir productDir) throws SQLException;
    // 删除数据
    public void deleteById(int id) throws SQLException;

}
