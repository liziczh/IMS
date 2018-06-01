package com.liziczh.ims.controller;

import com.liziczh.ims.service.IUserService;
import com.liziczh.ims.service.impl.UserServiceImpl;
import com.liziczh.ims.tools.VerifiCodeUtil;
import com.liziczh.ims.views.AbstractLoginFrame;

import javax.swing.*;

public class LoginController extends AbstractLoginFrame {
    private IUserService userService = new UserServiceImpl();
    @Override
    public void login(){
        String username = this.usernameText.getText();
        String password = new String(this.passwordText.getPassword());
        boolean isUser = false;
        boolean isCode = false;
        // 账号密码验证
        if(username != null && !"".equalsIgnoreCase(username) && password != null && !"".equalsIgnoreCase(password)){
            isUser = userService.login(username,password);
            if(!isUser){
                JOptionPane.showMessageDialog(this,"用户名和密码错误","温馨提示",JOptionPane.WARNING_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(this,"用户名和密码不能为空","温馨提示",JOptionPane.WARNING_MESSAGE);
        }

        // 验证码验证
        if(codeText.getText().equalsIgnoreCase(VerifiCodeUtil.getCode()) ){
            isCode = true;
        }else{
            isCode = false;
            JOptionPane.showMessageDialog(this, "验证码输入错误","温馨提示",JOptionPane.WARNING_MESSAGE);
            this.codeText.setText("");
            this.codeImgLabel.setIcon(new ImageIcon(VerifiCodeUtil.getBufferdImage(120,40)));
        }
        // 综合验证
        if(isUser && isCode){
            JOptionPane.showMessageDialog(this,"登陆成功","温馨提示",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new MainController(usernameText.getText()).stockInPanel.queryRecord();
        }
    }


}
