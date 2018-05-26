package com.liziczh.ims.dao;

import com.liziczh.ims.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDao {
    // 获取记录总数
    public int getTotalByCountAndDirName(String proName, int lowerCount, int upperCount, String dirName) throws SQLException;
    // 查询所有
    public List<Product> getAllProduct() throws SQLException;
    // 根据Count&Name查询
    public List<Product> getProductByCountAndDirName(String proName, int lowerCount, int upperCount, String dirName, int currentPage, int pageSize) throws SQLException;

    // 根据id查询
    public Product getProductById(int id);
    // 商品出库
    public boolean stockOut(int id,int count,String register);
}
