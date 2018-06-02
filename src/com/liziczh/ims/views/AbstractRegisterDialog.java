package com.liziczh.ims.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class AbstractRegisterDialog extends JDialog {
    private Font font = new Font("微软雅黑",Font.BOLD,14);
    // 标题
    private JLabel titleLabel = new JLabel();
    // 用户名
    private JLabel usernameLabel = new JLabel();
    protected JTextField usernameText = new JTextField();
    private JLabel usernameTipsLabel = new JLabel();
    // 密码
    private JLabel passwordLabel = new JLabel();
    protected JPasswordField passwordText = new JPasswordField();
    private JLabel passwordTipsLabel = new JLabel();
    // 确认密码
    private JLabel confirmLabel = new JLabel();
    protected JPasswordField confirmText = new JPasswordField();
    private JLabel confirmTipsLabel = new JLabel();
    // 手机号
    private JLabel mobileNumberLabel = new JLabel();
    protected JTextField mobileNumberText = new JTextField();
    private JLabel mobileNumberTipsLabel = new JLabel();
    // 邮箱
    private JLabel emailLabel = new JLabel();
    protected JTextField emailText = new JTextField();
    private JLabel emailTipsLabel = new JLabel();
    // 重置按钮
    private JButton resetBtn = new JButton();
    // 注册按钮
    private JButton registerBtn = new JButton();

    public AbstractRegisterDialog(){
        this.init();
    }

    private void init(){
        this.setTitle("进货入库");
        this.getContentPane().setBackground(Color.white);
        this.setIconImage(new ImageIcon("imgs/logo.png").getImage());
        this.setBounds(0,0,360,480);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.addComponent();
        this.addListener();
        this.setVisible(true);
    }

    private void addComponent(){
        // 标题
        titleLabel.setText("注册账号");
        titleLabel.setIcon(new ImageIcon("imgs/username.png"));
        titleLabel.setFont(new Font("微软雅黑",Font.PLAIN,20));
        titleLabel.setBounds(120,20,120,40);
        this.add(titleLabel);
        // 用户名
        usernameLabel.setText("用户名:");
        usernameLabel.setFont(font);
        usernameLabel.setBounds(40,80,100,30);
        this.add(usernameLabel);
        usernameText.setFont(font);
        usernameText.setBounds(110,80,200,30);
        usernameText.setToolTipText("使用字母和数字，长度为4-16个字符");
        this.add(usernameText);
        usernameTipsLabel.setFont(font);
        usernameTipsLabel.setBounds(320,80,40,30);
        this.add(usernameTipsLabel);
        // 密码
        passwordLabel.setText("密   码:");
        passwordLabel.setFont(font);
        passwordLabel.setBounds(40,120,100,30);
        this.add(passwordLabel);
        passwordText.setBounds(110,120,200,30);
        passwordText.setFont(font);
        passwordText.setToolTipText("使用字母和数字，长度为6-18个字符");
        this.add(passwordText);
        passwordTipsLabel.setFont(font);
        passwordTipsLabel.setBounds(320,120,40,30);
        this.add(passwordTipsLabel);

        // 确认密码
        confirmLabel.setText("确认密码:");
        confirmLabel.setFont(font);
        confirmLabel.setBounds(40,160,100,30);
        this.add(confirmLabel);
        confirmText.setBounds(110,160,200,30);
        confirmText.setFont(font);
        confirmText.setToolTipText("再次输入密码以保证密码无误");
        this.add(confirmText);
        confirmTipsLabel.setFont(font);
        confirmTipsLabel.setBounds(320,160,40,30);
        this.add(confirmTipsLabel);
        // 手机号
        mobileNumberLabel.setText("手 机 号：");
        mobileNumberLabel.setFont(font);
        mobileNumberLabel.setBounds(40,200,100,30);
        this.add(mobileNumberLabel);
        mobileNumberText.setBounds(110,200,200,30);
        mobileNumberText.setFont(font);
        mobileNumberText.setToolTipText("请输入您的联系方式");
        this.add(mobileNumberText);
        mobileNumberTipsLabel.setFont(font);
        mobileNumberTipsLabel.setBounds(320,200,40,30);
        this.add(mobileNumberTipsLabel);
        // 邮箱
        emailLabel.setText("邮   箱:");
        emailLabel.setFont(font);
        emailLabel.setBounds(40,240,100,30);
        this.add(emailLabel);
        emailText.setBounds(110,240,200,30);
        emailText.setFont(font);
        emailText.setToolTipText("如：example@gmail.com");
        this.add(emailText);
        emailTipsLabel.setFont(font);
        emailTipsLabel.setBounds(320,240,40,30);
        this.add(emailTipsLabel);

        // 重置按钮
        resetBtn.setText("重置");
        resetBtn.setFont(font);
        resetBtn.setBounds(40,360,100,30);
        resetBtn.setBackground(new Color(230,200,80));
        this.add(resetBtn);
        // 注册按钮
        registerBtn.setText("注册");
        registerBtn.setFont(font);
        registerBtn.setBounds(200,360,100,30);
        registerBtn.setBackground(new Color(80,150,230));
        this.add(registerBtn);

    }

    private void addListener(){
        // 验证用户名：/^[a-zA-Z0-9_-]{4,16}$/
        usernameText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if(usernameText.getText().matches("^[a-zA-Z0-9_-]{4,16}$")) {
                    usernameTipsLabel.setText("√");
                }else{
                    usernameTipsLabel.setText("×");
                }
            }
        });
        // 验证密码：/^[a-z0-9_-]{6,18}$/
        passwordText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if(String.valueOf(passwordText.getPassword()).matches("^[a-zA-Z0-9_-]{6,18}$")) {
                    passwordTipsLabel.setText("√");
                }else{
                    passwordTipsLabel.setText("×");
                }
            }
        });
        // 验证确认密码
        confirmText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if(!"".equals(String.valueOf(passwordText.getPassword())) && !"".equals(String.valueOf(confirmText.getPassword()))){
                    if(String.valueOf(passwordText.getPassword()).equals(String.valueOf(confirmText.getPassword()))) {
                        confirmTipsLabel.setText("√");
                    }else{
                        confirmTipsLabel.setText("×");
                    }
                }
            }
        });

        // 验证手机号
        mobileNumberText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if(mobileNumberText.getText().matches("^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$")) {
                    mobileNumberTipsLabel.setText("√");
                }else{
                    mobileNumberTipsLabel.setText("×");
                }
            }
        });
        // 验证邮箱：/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/
        emailText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if(emailText.getText().matches("^[a-z\\d]+(\\.[a-z\\d]+)*@([\\da-z](-[\\da-z])?)+(\\.{1,2}[a-z]+)+$")) {
                    emailTipsLabel.setText("√");
                }else{
                    emailTipsLabel.setText("×");
                }
            }
        });
        // 重置
        resetBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reset();
            }
        });
        // 注册
        registerBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                register();
            }
        });

    }
    public abstract void reset();
    public abstract void register();
}
