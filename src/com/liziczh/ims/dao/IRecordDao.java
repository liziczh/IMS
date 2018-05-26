package com.liziczh.ims.dao;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.domain.Record;

import java.sql.SQLException;
import java.util.List;

public interface IRecordDao {
    // 根据date查询
    public List<Record> getRecordByDateAndDirName(String beginDate, String endDate, String recordType, String dirName, int currentPage, int pageSize) throws SQLException;
    // 根据Name查询
    public List<Record> getRecordByName(String proName) throws SQLException;
    // 获取记录总数
    public int getTotalByDateAndDirName(String beginDate, String endDate, String recordType, String dirName) throws SQLException;
    // 全部查询
    public List<Record> getAllRecord() throws SQLException;
    // 插入数据
    public void insertRecord(Record record) throws SQLException;
    // 删除数据
    public void deleteById(int id) throws SQLException;
}
