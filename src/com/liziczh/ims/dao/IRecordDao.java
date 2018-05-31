package com.liziczh.ims.dao;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.domain.Record;

import java.sql.SQLException;
import java.util.List;

public interface IRecordDao {
    // 根据date查询
    public List<Record> getRecordByDateAndDirName(String beginDate, String endDate, String proName, String recordType, String dirName, int currentPage, int pageSize) throws SQLException;
    // 获取记录总数
    public int getTotalByDateAndDirName(String beginDate, String endDate, String proName, String recordType, String dirName) throws SQLException;

    // 插入记录
    public void insertRecord(Product product,int count,String register,String recoryType);

    // 更新记录信息
    public void updateRecord(int proId,String proName);
    // 获取统计信息
    public int getTotalCount(String recordType);
    public List<Object[]> getSumCountByDirName(String recordType, String startTime, String endTime);
}
