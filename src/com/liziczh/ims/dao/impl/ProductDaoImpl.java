package com.liziczh.ims.dao.impl;

import com.liziczh.ims.dao.IProductDao;
import com.liziczh.ims.domain.Product;
import com.liziczh.ims.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements IProductDao {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public List<Product> getProductByCountAndDirName(String proName, int lowerCount, int upperCount, String dirName, int currentPage, int pageSize) throws SQLException {
        List<Product>  proList = null;
        String sql = "select * from \"product\" where \"proName\" like '%' || ? || '%' and \"count\" between ? and ? ";
        String order = "order by \"proId\" ";
        if("全部".equals(dirName)){
            proList = queryRunner.query(JDBCUtils.PagenationSql(sql+order,currentPage,pageSize),new BeanListHandler<>(Product.class), proName, lowerCount, upperCount);
        }else{
            sql += " and \"dirName\" = ? ";
            proList = queryRunner.query(JDBCUtils.PagenationSql(sql+order,currentPage,pageSize),new BeanListHandler<>(Product.class),proName,lowerCount,upperCount,dirName);
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
            total = Integer.parseInt(queryRunner.query(sql,new ScalarHandler<>(1),proName,lowerCount,upperCount,dirName).toString());
        }
        return total;
    }

    @Override
    public List<Product> getAllProductByCountAndDirName(String proName, int lowerCount, int upperCount, String dirName) throws SQLException {
        List<Product>  proList = null;
        String sql = "select * from \"product\" where \"proName\" like '%' || ? || '%' and \"count\" between ? and ? ";
        String order = "order by \"proId\" ";
        if("全部".equals(dirName)){
            proList = queryRunner.query(sql+order,new BeanListHandler<>(Product.class), proName, lowerCount, upperCount);
        }else{
            sql += " and \"dirName\" = ? ";
            proList = queryRunner.query(sql+order,new BeanListHandler<>(Product.class),proName,lowerCount,upperCount,dirName);
        }
        return proList;
    }

    @Override
    public List<Product> getAllProduct() throws SQLException {
        String sql = "select * from \"product\" order by \"proId\" ";
        List<Product>  proList = queryRunner.query(sql,new BeanListHandler<>(Product.class));
        return proList;
    }

    @Override
    public Product getProductById(int id) throws SQLException {
        String sql = "select * from \"product\" where \"proId\" = ?";
        Product  product = queryRunner.query(sql,new BeanHandler<>(Product.class),id);
        return product;
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        String sql = "insert into \"product\" values(?,?,?,?,?,?)";
        queryRunner.update(sql,product.getProId(),product.getProName(), product.getDirName(),product.getSupplier(), product.getBrand(),product.getCount());
    }

    @Override
    public void updateProductCountPlus(Product product) throws SQLException {
        String sql = "update \"product\" set \"count\"= nvl(\"count\",0) + ? where \"proId\" = ?";
        queryRunner.update(sql,product.getCount(),product.getProId());
    }

    @Override
    public void updateProductCountSub(Product product, int count) throws SQLException {
        String sql = "update \"product\" set \"count\"= \"count\" - ? where \"proId\" = ?";
        queryRunner.update(sql,count,product.getProId());
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        String sql = "update \"product\" set \"proName\" = ?, \"dirName\" = ?, \"supplier\" = ?, \"brand\" = ? where \"proId\" = ?";
        queryRunner.update(sql,product.getProName(),product.getDirName(),product.getSupplier(),product.getBrand(),product.getProId());
    }

    @Override
    public void deleteAllProduct() throws SQLException {
        String sql = "delete from \"product\" ";
        queryRunner.update(sql);
    }


}
