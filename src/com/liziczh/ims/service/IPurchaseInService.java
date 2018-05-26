package com.liziczh.ims.service;

import com.liziczh.ims.domain.Product;

public interface IPurchaseInService {
    public void commitData(Product product, String register, String in);

}
