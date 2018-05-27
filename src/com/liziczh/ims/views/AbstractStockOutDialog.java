package com.liziczh.ims.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AbstractStockOutDialog extends JDialog {

    private Font font = new Font("微软雅黑",Font.BOLD,14);
    private JLabel titleLabel = new JLabel();
    private JLabel proId = new JLabel();
    protected JTextField proIdText = new JTextField();
    private JLabel proName = new JLabel();
    protected JTextField proNameText = new JTextField();
    private JLabel count = new JLabel();
    protected JTextField countText = new JTextField();
    private JLabel register = new JLabel();
    protected JTextField registerText = new JTextField();
    private JButton resetBtn = new JButton();
    private JButton outStockBtn = new JButton();
    protected String recordType = "out";

    public AbstractStockOutDialog(){
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
        titleLabel.setText("销售出库");
        titleLabel.setIcon(new ImageIcon("imgs/in.png"));
        titleLabel.setFont(new Font("微软雅黑",Font.PLAIN,20));
        titleLabel.setBounds(120,20,120,40);
        this.add(titleLabel);
        proId.setText("产品编号:");
        proId.setFont(font);
        proId.setBounds(40,80,100,30);
        this.add(proId);
        proIdText.setBounds(110,80,200,30);
        proIdText.setFont(font);
        this.add(proIdText);
        proName.setText("产品名称:");
        proName.setFont(font);
        proName.setBounds(40,120,100,30);
        this.add(proName);
        proNameText.setBounds(110,120,200,30);
        proNameText.setFont(font);
        this.add(proNameText);
        count.setText("产品数量:");
        count.setFont(font);
        count.setBounds(40,160,100,30);
        this.add(count);
        countText.setBounds(110,160,200,30);
        countText.setFont(font);
        this.add(countText);
        register.setText("负 责 人：");
        register.setFont(font);
        register.setBounds(40,200,100,30);
        this.add(register);
        registerText.setBounds(110,200,200,30);
        registerText.setFont(font);
        this.add(registerText);

        resetBtn.setText("重置");
        resetBtn.setFont(font);
        resetBtn.setBounds(40,260,100,30);
        resetBtn.setBackground(new Color(230,200,80));
        this.add(resetBtn);
        outStockBtn.setText("出库");
        outStockBtn.setFont(font);
        outStockBtn.setBounds(200,260,100,30);
        outStockBtn.setBackground(new Color(200,70,30));
        this.add(outStockBtn);

    }

    protected void addListener(){
        resetBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reset();
            }
        });
        outStockBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                stockOut();
            }
        });
    }
    public abstract void reset();
    public abstract void stockOut();

}

