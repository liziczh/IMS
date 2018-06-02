package com.liziczh.ims.service.impl;

import com.liziczh.ims.dao.IRecordDao;
import com.liziczh.ims.dao.impl.RecordDaoImpl;
import com.liziczh.ims.domain.Record;
import com.liziczh.ims.service.IRecordService;

import java.sql.SQLException;
import java.util.List;

public class RecordServiceImpl implements IRecordService {
    private IRecordDao recordDao = new RecordDaoImpl();
    @Override
    public List<Record> queryRecord(String beginDate, String endDate, String proName, String recordType, String dirName,int currentPage, int pageSize) {
        List<Record> recordList = null;
        try {
            recordList = recordDao.getRecordByDateAndDirName(beginDate,endDate,proName,recordType,dirName,currentPage,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordList;
    }

    @Override
    public int getTotal(String beginDate, String endDate, String proName, String recordType, String dirName) {
        int total = 0;
        try {
            total = recordDao.getTotalByDateAndDirName(beginDate, endDate, proName, recordType, dirName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public List<Record> queryAllRecord(String beginDate, String endDate, String proName, String recordType, String dirName) {
        List<Record> recordList = null;
        try {
            recordList = recordDao.getAllRecordByDateAndDirName(beginDate,endDate,proName,recordType,dirName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordList;
    }

    @Override
    public List<Record> getRecordByType(String recordType) {
        List<Record> recordList = null;
        try {
            recordList = recordDao.getRecordByType(recordType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordList;
    }

    @Override
    public void insertRecord(Record record) {
        try {
            recordDao.insertRecord(record);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear(String recordType) {
        try {
            recordDao.deleteAllRecord(recordType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
