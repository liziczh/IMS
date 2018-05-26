package com.liziczh.ims.dao;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.domain.Record;

import java.sql.SQLException;
import java.util.List;

public interface IRecordDao {
    // 根据date查询
    public List<Record> getRecordByDateAndDirName(String beginDate, String endDate, String recordType, String dirName, int currentPage, int pageSize) throws SQLException;
    // 获取记录总数
    public int getTotalByDateAndDirName(String beginDate, String endDate, String recordType, String dirName) throws SQLException;
    // 全部查询
    public List<Record> getAllRecord() throws SQLException;

    public void insertInStock(Product product, String register,String in);
    public void updateProduct(Product product);
    public void insertProduct(Product product);
    public void stockOut(Product product,int count);
    public void insertOutStock(Product product,int count,String register,String in);

}
