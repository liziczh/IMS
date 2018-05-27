package com.liziczh.ims.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AbstractSalesOutPanel extends JPanel {

    private Font font = new Font("微软雅黑",Font.BOLD,14);
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

    public AbstractSalesOutPanel(){
        this.init();
    }

    private void init(){
        this.setLayout(null);
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setBounds(0,0,650,500);
        this.addComponent();
        this.addListener();
    }

    private void addComponent(){
        proId.setText("产品编号:");
        proId.setFont(font);
        proId.setBounds(150,40,100,30);
        this.add(proId);
        proIdText.setBounds(220,40,200,30);
        proIdText.setFont(font);
        this.add(proIdText);
        proName.setText("产品名称:");
        proName.setFont(font);
        proName.setBounds(150,90,100,30);
        this.add(proName);
        proNameText.setBounds(220,90,200,30);
        proNameText.setFont(font);
        this.add(proNameText);
        count.setText("产品数量:");
        count.setFont(font);
        count.setBounds(150,140,100,30);
        this.add(count);
        countText.setBounds(220,140,200,30);
        countText.setFont(font);
        this.add(countText);
        register.setText("负 责 人：");
        register.setFont(font);
        register.setBounds(150,190,100,30);
        this.add(register);
        registerText.setBounds(220,190,200,30);
        registerText.setFont(font);
        this.add(registerText);

        resetBtn.setText("重置");
        resetBtn.setFont(font);
        resetBtn.setBounds(150,290,100,30);
        resetBtn.setBackground(new Color(230,200,80));
        this.add(resetBtn);
        outStockBtn.setText("出库");
        outStockBtn.setFont(font);
        outStockBtn.setBounds(320,290,100,30);
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
                outStock();
            }
        });
    }
    public abstract void reset();
    public abstract void outStock();

}

