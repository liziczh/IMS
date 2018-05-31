package com.liziczh.ims.service;

import com.liziczh.ims.domain.Record;

import java.util.List;

public interface IRecordService {
    // 查询记录
    public List<Record> queryRecord(String beginDate, String endDate, String proName, String recordType, String dirName,int currentPage, int pageSize);
    public int getTotal(String beginDate, String endDate, String proName, String recordType, String dirName);

}
