package com.liziczh.ims.service;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.domain.Record;

import java.util.List;

public interface IProductService {
    // 通过查询条件查询产品
    public List<Product> queryProduct(String proName, int lowerCount, int upperCount, String dirName,int currentPage, int pageSize);
    // 获取查询的总记录数（服务于分页功能使用）
    public int getTotal(String proName, int lowerCount, int upperCount, String dirName);
    // 通过ID查询一件商品
    public Product queryProductById(int proId);
    // 通过查询条件查询产品
    public List<Product> queryAllProduct(String proName, int lowerCount, int upperCount, String dirName);

    // 获取商品
    public List<Product> getAllProduct();
    // 插入一件商品
    public void insertProduct(Product product);

    // 删除所有记录
    public void clear();

}
