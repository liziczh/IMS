package com.liziczh.ims.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AbstractInventoryMngPanel extends JPanel {

    private Font font = new Font("微软雅黑",Font.BOLD,14);
    private JLabel proId = new JLabel();
    private JTextField proIdText = new JTextField();
    private JLabel proName = new JLabel();
    private JTextField proNameText = new JTextField();
    private JLabel dirId = new JLabel();
    // 分类下拉框
    private String[] def = {"全部","家用电器","数码产品","电脑/办公","家居/家具","食品","图书","其他"};
    protected JComboBox dirBox = new JComboBox<>(def);
    private JLabel supplier = new JLabel();
    private JTextField supplierText = new JTextField();
    private JLabel brand = new JLabel();
    private JTextField brandText = new JTextField();
    protected JButton resetBtn = new JButton();
    protected JButton modifyBtn = new JButton();

    public AbstractInventoryMngPanel(){
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
        proName.setBounds(150,80,100,30);
        this.add(proName);
        proNameText.setBounds(220,80,200,30);
        proNameText.setFont(font);
        this.add(proNameText);
        dirId.setText("分   类 :");
        dirId.setFont(font);
        dirId.setBounds(150,120,100,30);
        this.add(dirId);
        dirBox.setBounds(220,120,200,30);
        dirBox.setFont(font);
        dirBox.setBackground(Color.white);
        this.add(dirBox);
        supplier.setText("供 应 商：");
        supplier.setFont(font);
        supplier.setBounds(150,160,100,30);
        this.add(supplier);
        supplierText.setBounds(220,160,200,30);
        supplierText.setFont(font);
        this.add(supplierText);
        brand.setText("产品商标:");
        brand.setFont(font);
        brand.setBounds(150,200,100,30);
        this.add(brand);
        brandText.setBounds(220,200,200,30);
        brandText.setFont(font);
        this.add(brandText);

        resetBtn.setText("重置");
        resetBtn.setFont(font);
        resetBtn.setBounds(150,300,100,30);
        resetBtn.setBackground(new Color(230,200,80));
        this.add(resetBtn);
        modifyBtn.setText("修改");
        modifyBtn.setFont(font);
        modifyBtn.setBounds(320,300,100,30);
        modifyBtn.setBackground(new Color(80,150,230));
        this.add(modifyBtn);

    }

    private void addListener(){
        modifyBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modify();
            }
        });
    }

    public abstract void modify();

}

