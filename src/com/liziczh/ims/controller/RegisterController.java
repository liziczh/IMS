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
        String password = String.valueOf(passwordText.getPassword());
        String confirm = String.valueOf(confirmText.getPassword());
        if(username != null && password != null && confirm != null ){
            if(!"".equals(username) && !"".equals(password) && !"".equals(confirm)){
                userService.register(username,password);
                JOptionPane.showMessageDialog(this,"注册成功","温馨提示",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this,"用户名或密码不能为空","温馨提示",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    @Override
    public void confirm() {
        // 判断密码与确认密码是否一致
        if(String.valueOf(passwordText.getPassword()) != "" && String.valueOf(confirmText.getPassword()) != ""){
            if(String.valueOf(passwordText.getPassword()).equals(String.valueOf(confirmText.getPassword()))) {
                promptLabel.setText("√");
            }else{
                promptLabel.setText("×");
            }
        }
    }
}
