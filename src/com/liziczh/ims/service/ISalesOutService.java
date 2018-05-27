package com.liziczh.ims.service;

import com.liziczh.ims.domain.Product;

public interface ISalesOutService {
    public Product checkProduct(int id, int count);
    public void outStock(int id, int count, String register, String recordType);
}
