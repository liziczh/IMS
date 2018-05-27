package com.liziczh.ims.service;

import com.liziczh.ims.domain.Product;

public interface IStockInService {
    public void stockIn(Product product, String register, String recordType);

}
