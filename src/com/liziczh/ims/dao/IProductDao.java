package com.liziczh.ims.dao;

import com.liziczh.ims.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDao {
    // 获取记录总数
    public int getTotalByCountAndDirName(String proName, int lowerCount, int upperCount, String dirName) throws SQLException;
    // 根据Count&Name分页查询
    public List<Product> getProductByCountAndDirName(String proName, int lowerCount, int upperCount, String dirName, int currentPage, int pageSize) throws SQLException;
    // 根据Count&Name查询所有
    public List<Product> getAllProductByCountAndDirName(String proName, int lowerCount, int upperCount, String dirName) throws SQLException;
    // 获取全部
    public List<Product> getAllProduct() throws SQLException;

    // 根据id查询
    public Product getProductById(int id) throws SQLException;
    // 插入产品
    public void insertProduct(Product product) throws SQLException;
    // 更新产品库存
    public void updateProductCountPlus(Product product) throws SQLException;
    public void updateProductCountSub(Product product,int count) throws SQLException;

    // 更新产品信息
    public void updateProduct(Product product) throws SQLException;

    // 删除全部商品
    public void deleteAllProduct() throws SQLException;
}
