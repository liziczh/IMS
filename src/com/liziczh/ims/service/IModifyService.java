package com.liziczh.ims.service;

import com.liziczh.ims.domain.Product;

public interface IModifyService {
    public Product getProductById(int proId);
    public void modify(Product product);
}
