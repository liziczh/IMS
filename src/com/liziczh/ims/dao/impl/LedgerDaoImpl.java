package com.liziczh.ims.dao.impl;

import com.liziczh.ims.dao.ILedgerDao;
import com.liziczh.ims.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class LedgerDaoImpl implements ILedgerDao {
    DataSource ds = JDBCUtils.getDataSource();
    QueryRunner queryRunner = new QueryRunner(ds);
    @Override
    public int getTotalCount(String recordType) {
        String sql = "select sum(\"count\") from \"record\" WHERE \"recordType\" = ?";
        int res = 0;
        try {
            res = new Integer(queryRunner.query(sql,new ScalarHandler<>(1),recordType).toString());
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Object[]> getSumCountByDirName(String recordType, String startTime, String endTime) {
        String sql = "select sum(\"record\".\"count\"),\"product\".\"dirName\" " +
                "from \"record\",\"product\" " +
                "WHERE \"record\".\"proId\" = \"product\".\"proId\" " +
                "AND \"recordType\" = ? " +
                "AND \"record\".\"date\" BETWEEN ? AND ? " +
                "GROUP BY \"product\".\"dirName\"";
        try {
            return queryRunner.query(sql,new ArrayListHandler(),recordType,startTime,endTime);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
