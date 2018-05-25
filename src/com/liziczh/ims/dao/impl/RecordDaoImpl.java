package com.liziczh.ims.dao.impl;

import com.liziczh.ims.dao.IRecordDao;
import com.liziczh.ims.domain.Record;
import com.liziczh.ims.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class RecordDaoImpl implements IRecordDao {
    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public List<Record> getRecordByDateAndDirName(String beginDate,String endDate, String recordType,String dirName) throws SQLException {
        List<Record> recordList = null;
        String sql = "select * from \"record\" where (\"date\" between ? and ?) and \"recordType\" = ? ";
        if(dirName.equals("全部")){
            recordList = queryRunner.query(sql,new BeanListHandler<Record>(Record.class),beginDate,endDate,recordType);
        }else{
            sql += " and \"record\".\"proName\" in (" +
                    "select \"proName\" " +
                    "from \"product\" " +
                    "where \"product\".\"proId\" = (" +
                    "select \"proId\" " +
                    "from \"productDir\" " +
                    "where \"productDir\".\"dirName\" = ?" +
                    "))";
            recordList = queryRunner.query(sql,new BeanListHandler<Record>(Record.class),beginDate,endDate,recordType,dirName);
        }
        return recordList;
    }

    @Override
    public List<Record> getRecordByName(String proName) throws SQLException {
        String sql = "select * from \"record\" where \"proName\" = ?";
        List<Record> recordList = queryRunner.query(sql,new BeanListHandler<Record>(Record.class),proName);
        return recordList;
    }

    @Override
    public void insertRecord(Record record) throws SQLException {
        String sql = "insert into \"record\" values(?,?,?,?,?,?)";
        queryRunner.update(sql,record.getDate(),record.getProId(),record.getProName(),record.getCount(),record.getRegister(),record.getRecordType());
    }

    @Override
    public void deleteById(int id) throws SQLException {
        String sql = "delete from \"record\" where \"id\" = ?";
        queryRunner.update(sql,id);
    }

}
