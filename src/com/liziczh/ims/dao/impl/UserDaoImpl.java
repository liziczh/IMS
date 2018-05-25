package com.liziczh.ims.dao.impl;

import com.liziczh.ims.dao.IUserDao;
import com.liziczh.ims.domain.User;
import com.liziczh.ims.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {

    @Override
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from \"user\" where \"username\" = ? and \"password\" = ?";
        User user = queryRunner.query(sql,new BeanHandler<User>(User.class),username,password);
        return user;
    }
}
