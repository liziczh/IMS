package com.liziczh.ims.service.impl;

import com.liziczh.ims.dao.IUserDao;
import com.liziczh.ims.dao.impl.UserDaoImpl;
import com.liziczh.ims.domain.User;
import com.liziczh.ims.service.IUserService;
import com.liziczh.ims.tools.MD5Util;

import java.sql.SQLException;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao = new UserDaoImpl();
    @Override
    public boolean login(String username, String password) {
        try {
            User user = userDao.getUserByUsernameAndPassword(username,MD5Util.MD5Encode(password).toUpperCase());
            if(user != null){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void register(User user) {
        try {
            userDao.insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
