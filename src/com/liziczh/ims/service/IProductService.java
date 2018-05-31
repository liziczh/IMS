package com.liziczh.ims.service;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.domain.Record;

import java.util.List;

public interface IProductService {
    // 查询产品
    public List<Product> queryProduct(String proName, int lowerCount, int upperCount, String dirName,int currentPage, int pageSize);
    public int getTotal(String proName, int lowerCount, int upperCount, String dirName);
    public Product queryProductById(int proId);

}
