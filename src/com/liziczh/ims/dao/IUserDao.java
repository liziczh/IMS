package com.liziczh.ims.dao;

import com.liziczh.ims.domain.User;
import java.sql.SQLException;

public interface IUserDao {
    // 根据用户名&密码获取用户
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException;
    // 插入新用户
    public void insertUser(User user) throws SQLException;
}
