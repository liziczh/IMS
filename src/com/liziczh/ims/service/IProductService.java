package com.liziczh.ims.service;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.domain.Record;

import java.util.List;

public interface IProductService {
    public List<Product> queryProduct(String proName, int lowerCount, int upperCount, String dirName,int currentPage, int pageSize);
    public int getTotal(String proName, int lowerCount, int upperCount, String dirName);
    public List<Product> queryAll();
    public Product queryProductById(int proId);

}
