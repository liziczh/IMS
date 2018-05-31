package com.liziczh.ims.dao.impl;

import com.liziczh.ims.dao.IUserDao;
import com.liziczh.ims.domain.User;
import com.liziczh.ims.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        String sql = "select * from \"user\" where \"username\" = ? and \"password\" = ?";
        User user = queryRunner.query(sql,new BeanHandler<User>(User.class),username,password);
        return user;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        String sql = "insert into \"user\" values(id_seq.nextval, ?, FN_MD5(?), ?, ?)";
        queryRunner.update(sql,user.getUsername(),user.getPassword(),user.getMobileNumber(),user.getEmail());
    }
}
