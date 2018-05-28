package com.liziczh.ims.dao;

import java.util.List;

public interface ILedgerDao {
    public int getTotalCount(String recordType);
    public List<Object[]> getSumCountByDirName(String recordType, String startTime, String endTime);
}
