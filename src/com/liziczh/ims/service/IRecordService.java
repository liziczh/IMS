package com.liziczh.ims.service;

import com.liziczh.ims.domain.Record;

import java.util.List;

public interface IRecordService {

    public List<Record> queryRecord(String beginDate, String endDate, String recordType, String dirName,int currentPage, int pageSize);
    public int getTotal(String beginDate, String endDate, String recordType, String dirName);
    public List<Record> queryAll();

}
