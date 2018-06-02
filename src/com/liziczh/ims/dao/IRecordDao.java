package com.liziczh.ims.dao;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.domain.Record;

import java.sql.SQLException;
import java.util.List;

public interface IRecordDao {
    // 根据date分页查询
    public List<Record> getRecordByDateAndDirName(String beginDate, String endDate, String proName, String recordType, String dirName, int currentPage, int pageSize) throws SQLException;
    // 获取记录总数
    public int getTotalByDateAndDirName(String beginDate, String endDate, String proName, String recordType, String dirName) throws SQLException;
    // 根据date查询所有
    public List<Record> getAllRecordByDateAndDirName(String beginDate, String endDate, String proName, String recordType, String dirName) throws SQLException;

    // 获取全部
    public List<Record> getAllRecord() throws SQLException;

    // 获取入库记录
    public List<Record> getRecordByType(String recordType) throws SQLException;
    // 插入记录
    public void insertRecord(Product product,int count,String register,String recoryType) throws SQLException;
    // 插入记录
    public void insertRecord(Record record) throws SQLException;
    // 更新记录信息
    public void updateRecord(int proId,String proName) throws SQLException;
    // 获取统计信息
    public int getTotalCount(String recordType) throws SQLException;
    public List<Object[]> getSumCountByDirName(String recordType, String startTime, String endTime) throws SQLException;

    // 删除全部记录
    public void deleteAllRecord(String recordType) throws SQLException;
}
