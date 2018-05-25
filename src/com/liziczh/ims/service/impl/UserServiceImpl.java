package com.liziczh.ims.service.impl;

import com.liziczh.ims.dao.IUserDao;
import com.liziczh.ims.dao.impl.UserDaoImpl;
import com.liziczh.ims.domain.User;
import com.liziczh.ims.service.IUserService;

import java.sql.SQLException;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao = new UserDaoImpl();
    @Override
    public boolean login(String username, String password) {
        User user = null;
        try {
            user = userDao.getUserByUsernameAndPassword(username,password);
            if(user != null){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
