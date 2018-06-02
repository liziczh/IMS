package com.liziczh.ims.service;

import com.liziczh.ims.domain.Record;

import java.util.List;

public interface IRecordService {
    // 查询记录
    public List<Record> queryRecord(String beginDate, String endDate, String proName, String recordType, String dirName,int currentPage, int pageSize);
    // 获取结果集的总记录数（服务于分页）
    public int getTotal(String beginDate, String endDate, String proName, String recordType, String dirName);

    // 获取记录
    public List<Record> getRecordByType (String recordType);
    // 导入记录
    public void insertAllRecord();

}
