package com.liziczh.ims.dao.impl;

import com.liziczh.ims.dao.IProductDao;
import com.liziczh.ims.domain.Product;
import com.liziczh.ims.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements IProductDao {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    private int total = 0;
    @Override
    public List<Product> getProductByCountAndDirName(String proName, int lowerCount, int upperCount, String dirName, int currentPage, int pageSize) throws SQLException {
        List<Product>  proList = null;
        String sql = "select * from \"product\" where \"proName\" like '%' || ? || '%' and \"count\" between ? and ? ";
        if("全部".equals(dirName)){
            proList = queryRunner.query(JDBCUtils.PagenationSql(sql,currentPage,pageSize),new BeanListHandler<>(Product.class), proName, lowerCount, upperCount);
        }else{
            sql += " and \"dirName\" = ? ";
            proList = queryRunner.query(JDBCUtils.PagenationSql(sql,currentPage,pageSize),new BeanListHandler<>(Product.class),proName,lowerCount,upperCount,dirName);
        }
        return proList;
    }

    @Override
    public int getTotalByCountAndDirName(String proName, int lowerCount, int upperCount, String dirName) throws SQLException {
        int total ;
        String sql = "select count(*) from \"product\" where \"proName\" like '%' || ? || '%' and \"count\" between ? and ? ";
        if("全部".equals(dirName)){
            total = Integer.parseInt(queryRunner.query(sql,new ScalarHandler<>(1), proName, lowerCount, upperCount).toString());
        }else{
            sql += " and \"dirName\" = ? ";
            total = Integer.parseInt(queryRunner.query(sql,new ScalarHandler<>(1),proName,lowerCount,upperCount,dirName));
        }
        return total;
    }

    @Override
    public List<Product> getAllProduct() throws SQLException {
        String sql = "select * from \"product\"";
        List<Product> proList  = queryRunner.query(sql,new BeanListHandler<>(Product.class));
        return proList;
    }

    @Override
    public Product getProductById(int id) {
        String sql = "select * from \"product\" where \"proId\" = ?";
        Product  product = null;
        try {
            product= queryRunner.query(sql,new BeanHandler<>(Product.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean stockOut(int id,int count,String register) {
        String sql = "update \"product\" set \"count\" = \"count\" - ? where \"proId\" = ? ";
        try {
            queryRunner.update(sql,id,count);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



}
