package com.liziczh.ims.service;

public interface IUserService{
    public boolean login(String username, String password);
    public void register(String username, String password);
}
