package com.liziczh.ims.service;

import com.liziczh.ims.domain.Product;

public interface IModifyService {
    // 商品信息管理
    public Product getProductById(int proId);
    public void modify(Product product);
}
