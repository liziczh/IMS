package com.liziczh.ims.service;

import com.liziczh.ims.domain.Product;

import java.util.List;

public interface IProductService {
    public List<Product> queryProduct(String proName, int lowerCount, int upperCount, String dirName);
}
