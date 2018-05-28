package com.liziczh.ims.controller;

import com.liziczh.ims.service.IUserService;
import com.liziczh.ims.service.impl.UserServiceImpl;
import com.liziczh.ims.views.AbstractRegisterDialog;

import javax.swing.*;

public class RegisterController extends AbstractRegisterDialog {
    private IUserService userService = new UserServiceImpl();

    @Override
    public void reset() {
        usernameText.setText("");
        passwordText.setText("");
        confirmText.setText("");
    }

    @Override
    public void register() {
        String username = usernameText.getText();
        String password = passwordText.getText();
        String confirm = confirmText.getText();
        if(username != null && password != null && confirm != null ){
            if(!"".equals(username) && !"".equals(password) && !"".equals(confirm)){
                if(password.equals(confirm)){
                    userService.register(username,password);
                    JOptionPane.showMessageDialog(this,"注册成功","温馨提示",JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this,"请确认两次密码输入一致---","温馨提示",JOptionPane.WARNING_MESSAGE);
                }
            }else{
                    JOptionPane.showMessageDialog(this,"用户名或密码不能为空","温馨提示",JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
