package com.liziczh.ims.controller;

import com.liziczh.ims.domain.User;
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
        String mobileNumber = mobileNumberText.getText();
        String email = emailText.getText();
        if(username != null && password != null && confirm != null && mobileNumber != null && email != null){
            if(usernameText.getText().matches("^[a-zA-Z0-9_-]{4,16}$")) {
                if(String.valueOf(passwordText.getPassword()).matches("^[a-zA-Z0-9_-]{6,18}$")) {
                    if(String.valueOf(passwordText.getPassword()).equals(String.valueOf(confirmText.getPassword()))){
                        if(mobileNumberText.getText().matches("^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$")){
                            if(emailText.getText().matches("^[a-z\\d]+(\\.[a-z\\d]+)*@([\\da-z](-[\\da-z])?)+(\\.{1,2}[a-z]+)+$")){
                                User user = new User(0, username, password, mobileNumber, email);
                                userService.register(user);
                                JOptionPane.showMessageDialog(this, "注册成功", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
                                this.dispose();
                            }else{
                                JOptionPane.showMessageDialog(this,"Email输入错误","温馨提示",JOptionPane.WARNING_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(this,"手机号输入错误","温馨提示",JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(this,"请确认两次密码输入一致","温馨提示",JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this,"密码不合法，请输入由字母/数字/下划线/中划线组成的6-18位密码","温馨提示",JOptionPane.WARNING_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this,"用户名不合法","温馨提示",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

}
