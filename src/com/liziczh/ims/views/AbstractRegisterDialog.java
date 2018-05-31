package com.liziczh.ims.views;

import jdk.nashorn.internal.scripts.JD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class AbstractRegisterDialog extends JDialog {
    private Font font = new Font("微软雅黑",Font.BOLD,14);
    private JLabel titleLabel = new JLabel();
    private JLabel usernameLabel = new JLabel();
    protected JTextField usernameText = new JTextField();
    private JLabel passwordLabel = new JLabel();
    protected JPasswordField passwordText = new JPasswordField();
    private JLabel confirmLabel = new JLabel();
    protected JPasswordField confirmText = new JPasswordField();
    protected JLabel promptLabel = new JLabel();
    private JButton resetBtn = new JButton();
    private JButton registerBtn = new JButton();

    public AbstractRegisterDialog(){
        this.init();
    }

    private void init(){
        this.setTitle("进货入库");
        this.getContentPane().setBackground(Color.white);
        this.setIconImage(new ImageIcon("imgs/logo.png").getImage());
        this.setBounds(0,0,360,400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.addComponent();
        this.addListener();
        this.setVisible(true);
    }

    private void addComponent(){
        titleLabel.setText("注册账号");
        titleLabel.setIcon(new ImageIcon("imgs/username.png"));
        titleLabel.setFont(new Font("微软雅黑",Font.PLAIN,20));
        titleLabel.setBounds(120,20,120,40);
        this.add(titleLabel);
        usernameLabel.setText("用户名:");
        usernameLabel.setFont(font);
        usernameLabel.setBounds(40,80,100,30);
        this.add(usernameLabel);
        usernameText.setBounds(110,80,200,30);
        usernameText.setFont(font);
        this.add(usernameText);
        passwordLabel.setText("密码:");
        passwordLabel.setFont(font);
        passwordLabel.setBounds(40,120,100,30);
        this.add(passwordLabel);
        passwordText.setBounds(110,120,200,30);
        passwordText.setFont(font);
        this.add(passwordText);
        confirmLabel.setText("确认密码:");
        confirmLabel.setFont(font);
        confirmLabel.setBounds(40,160,100,30);
        this.add(confirmLabel);
        confirmText.setBounds(110,160,200,30);
        confirmText.setFont(font);
        this.add(confirmText);
        promptLabel.setText("");
        promptLabel.setBounds(320,160,20,30);
        promptLabel.setFont(font);
        this.add(promptLabel);

        resetBtn.setText("重置");
        resetBtn.setFont(font);
        resetBtn.setBounds(40,260,100,30);
        resetBtn.setBackground(new Color(230,200,80));
        this.add(resetBtn);
        registerBtn.setText("注册");
        registerBtn.setFont(font);
        registerBtn.setBounds(200,260,100,30);
        registerBtn.setBackground(new Color(80,150,230));
        this.add(registerBtn);

    }

    protected void addListener(){
        confirmText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        confirmText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                confirm();
            }
        });

        resetBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reset();
            }
        });
        registerBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                register();
            }
        });
        this.getContentPane().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        register();
                }
            }
        });

    }
    public abstract void reset();
    public abstract void register();
    public abstract void confirm();

}
