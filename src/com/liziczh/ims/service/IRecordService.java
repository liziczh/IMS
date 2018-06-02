package com.liziczh.ims.service;

import com.liziczh.ims.domain.Record;

import java.util.List;

public interface IRecordService {
    // 分页查询记录
    public List<Record> queryRecord(String beginDate, String endDate, String proName, String recordType, String dirName,int currentPage, int pageSize);
    // 获取结果集的总记录数（服务于分页）
    public int getTotal(String beginDate, String endDate, String proName, String recordType, String dirName);
    // 查询所有
    public List<Record> queryAllRecord(String beginDate, String endDate, String proName, String recordType, String dirName);

    // 获取记录
    public List<Record> getRecordByType (String recordType);

    // 插入一条记录
    public void insertRecord(Record record);

    // 删除所有记录
    public void clear(String recordType);

}
