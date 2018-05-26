package com.liziczh.ims.dao;

import com.liziczh.ims.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDao {
    // 根据id查询
    public Product getProductById(int id) throws SQLException;
    // 根据Name查询
    public List<Product> getProductByCountAndDirName(String proName, int lowerCount, int upperCount, String dirName, int currentPage, int pageSize) throws SQLException;
    // 获取记录总数
    public int getTotalByCountAndDirName(String proName, int lowerCount, int upperCount, String dirName) throws SQLException;
    // 查询所有
    public List<Product> getAllProduct() throws SQLException;
    // 插入数据
    public void insertProduct(Product product) throws SQLException;
    // 修改数据
    public void updateProduct(Product product) throws SQLException;
    // 删除数据
    public void deleteById(int id) throws SQLException;

}
