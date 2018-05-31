package com.liziczh.ims.service;

import com.liziczh.ims.domain.User;

public interface IUserService{
    public boolean login(String username, String password);
    public void register(User user);
}
