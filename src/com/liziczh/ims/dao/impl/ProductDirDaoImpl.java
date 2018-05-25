package com.liziczh.ims.dao.impl;

import com.liziczh.ims.dao.IProductDirDao;
import com.liziczh.ims.domain.ProductDir;
import com.liziczh.ims.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDirDaoImpl implements IProductDirDao {
    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public ProductDir getProductDirById(int id) throws SQLException {
        String sql = "select * from \"productDir\" where \"proId\" = ?";
        ProductDir productDir = queryRunner.query(sql,new BeanHandler<ProductDir>(ProductDir.class),id);
        return productDir;
    }

    @Override
    public List<ProductDir> getAllProductDir() throws SQLException {
        String sql = "select * from \"productDir\"";
        List<ProductDir> productDirList = queryRunner.query(sql,new BeanListHandler<ProductDir>(ProductDir.class));
        return productDirList;
    }

    @Override
    public void insertProduct(ProductDir productDir) throws SQLException {
        String sql = "insert into \"productDir\" values(?,?)";
        queryRunner.update(sql,productDir.getDirId(),productDir.getDirName());
    }

    @Override
    public void deleteById(int id) throws SQLException {
        String sql = "delete from \"productDir\" where \"id\" = ?";
        queryRunner.update(sql,id);
    }
}
