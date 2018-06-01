package com.liziczh.ims.views;

import com.liziczh.ims.controller.LoginController;
import com.liziczh.ims.controller.RegisterController;
import com.liziczh.ims.tools.VerifiCodeUtil;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public abstract class AbstractLoginFrame extends JFrame {

    private Font font = new Font("微软雅黑",Font.BOLD,16);

    private JPanel loginPanel = new JPanel(); // 登陆面板
    private JLabel loginImg = new JLabel(new ImageIcon("imgs/mainbg1.jpg")); // 登陆背景图
    private JLabel loginLabel = new JLabel();
    private JLabel usernameLabel = new JLabel(); // 用户名标签
    private JLabel passwordLabel = new JLabel(); // 密码标签
    private JLabel codeLabel = new JLabel(); // 验证码标签
    protected JLabel codeImgLabel = new JLabel(); // 验证码图片
    protected JTextField usernameText = new JTextField(); // 用户名文本框
    protected JPasswordField passwordText = new JPasswordField(); // 密码文本框
    protected JTextField codeText = new JTextField(); // 验证码文本框
    private JLabel autherLabel = new JLabel(); // 作者标签
    private JButton loginBtn = new JButton(); // 登陆按钮
    private JButton registerBtn = new JButton(); // 注册按钮

    public AbstractLoginFrame(){
        this.init();
    }

    private void init(){
        this.setTitle("IMS-login"); // 设置窗口Frame标题
        this.setIconImage(new ImageIcon("imgs/logo.png").getImage()); // 设置窗口Frame
        this.setSize(600,400); // 设置窗口大小
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addComponent();
        this.addListener();
        this.setVisible(true);
    }

    private void addComponent(){
        // Panel的设置
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.white);
        // 登陆标签
        loginLabel.setText(" IMS");
        loginLabel.setIcon(new ImageIcon("imgs/logo32.png"));
        loginLabel.setFont(new Font("等线",Font.PLAIN,36));
        loginLabel.setBounds(240,70,150,50);
        this.add(loginLabel);
        // 账号组件
        usernameLabel.setText(" 用户名：");
        usernameLabel.setIcon(new ImageIcon("imgs/username.png"));
        usernameLabel.setFont(font);
        usernameLabel.setBounds(150,140,90,30);
        loginPanel.add(usernameLabel);
        usernameText.setFont(font);
        usernameText.setBounds(240,140,200,30);
        loginPanel.add(usernameText);
        // 密码组件
        passwordLabel.setText(" 密   码：");
        passwordLabel.setIcon(new ImageIcon("imgs/password.png"));
        passwordLabel.setFont(font);
        passwordLabel.setBounds(150,180,90,30);
        loginPanel.add(passwordLabel);
        passwordText.setFont(font);
        passwordText.setBounds(240,180,200,30);
        loginPanel.add(passwordText);
        // 验证码组件
        codeLabel.setText(" 验证码：");
        codeLabel.setIcon(new ImageIcon("imgs/verifiCode.png"));
        codeLabel.setBounds(150,220,90,30);
        codeLabel.setFont(font);
        loginPanel.add(codeLabel);
        codeText.setFont(font);
        codeText.setBounds(240,220,75,30);
        loginPanel.add(codeText);
        // 验证码图片
        codeImgLabel.setIcon(new ImageIcon(VerifiCodeUtil.getBufferdImage(120,40)));
        codeImgLabel.setBounds(320,220,120,30);
        loginPanel.add(codeImgLabel);
        // 注册按钮
        registerBtn.setText("注  册");
        registerBtn.setFont(font);
        registerBtn.setBackground(Color.white);
        registerBtn.setBounds(180,280, 120,30);
        this.add(registerBtn);
        // 登陆按钮
        loginBtn.setText("登  陆");
        loginBtn.setFont(font);
        loginBtn.setBackground(Color.white);
        loginBtn.setBounds(320,280, 120,30);

        loginPanel.add(loginBtn);
        // 作者信息
        autherLabel.setFont(font);
        autherLabel.setBounds(500,340,100,20);
        autherLabel.setText("@Mistake");
        loginPanel.add(autherLabel);
        // 背景图
        loginImg.setBounds(0,0,this.getWidth(),this.getHeight());
        loginPanel.add(loginImg);
        this.add(loginPanel);

    }

    private void addListener(){

        // 切换验证码图片
        codeImgLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                codeImgLabel.setIcon(new ImageIcon(VerifiCodeUtil.getBufferdImage(120,40)));
            }
        });
        // 登陆
        loginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                login();
            }
        });

        // 注册
        registerBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new RegisterController();
            }
        });

        // 键盘登陆
        usernameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        login();
                }
            }
        });
        passwordText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        login();
                }
            }
        });
        codeText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        login();
                }
            }
        });

    }
    public abstract void login();

}
