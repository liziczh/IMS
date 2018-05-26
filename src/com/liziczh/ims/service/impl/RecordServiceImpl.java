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
        public List<Record> queryRecord(String beginDate, String endDate, String recordType, String dirName) {
            List<Record> recordList = null;
            try {
                recordList = recordDao.getRecordByDateAndDirName(beginDate,endDate,recordType,dirName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return recordList;
        }

}
