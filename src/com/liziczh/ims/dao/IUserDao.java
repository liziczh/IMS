package com.liziczh.ims.dao;

import com.liziczh.ims.domain.User;
import java.sql.SQLException;

public interface IUserDao {
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException;
}
