package com.liziczh.ims.service;

import com.liziczh.ims.domain.Product;

public interface IStockIOService {
    // 入库
    public void stockIn(Product product, String register, String recordType);
    // 出库
    public Product checkProduct(int id, int count);
    public void stockOut(int id, int count, String register, String recordType);
}
