package com.liziczh.ims.views;

import javax.swing.*;
import java.awt.*;

public class InventoryMngPanel extends JPanel {

    private Font font = new Font("微软雅黑",Font.BOLD,14);
    private JLabel proId = new JLabel();
    private JTextField proIdText = new JTextField();
    private JLabel proName = new JLabel();
    private JTextField proNameText = new JTextField();
    private JLabel dirId = new JLabel();
    private JTextField dirIdText = new JTextField();
    private JLabel supplier = new JLabel();
    private JTextField supplierText = new JTextField();
    private JLabel brand = new JLabel();
    private JTextField brandText = new JTextField();
    private JLabel count = new JLabel();
    private JTextField countText = new JTextField();
    protected JButton resetBtn = new JButton();
    protected JButton commitBtn = new JButton();

    public InventoryMngPanel(){
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
        dirId.setText("分类编号:");
        dirId.setFont(font);
        dirId.setBounds(150,120,100,30);
        this.add(dirId);
        dirIdText.setBounds(220,120,200,30);
        dirIdText.setFont(font);
        this.add(dirIdText);
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
        count.setText("产品数量:");
        count.setFont(font);
        count.setBounds(150,240,100,30);
        this.add(count);
        countText.setBounds(220,240,200,30);
        countText.setFont(font);
        this.add(countText);

        resetBtn.setText("重置");
        resetBtn.setFont(font);
        resetBtn.setBounds(150,300,100,30);
        resetBtn.setBackground(new Color(230,200,80));
        this.add(resetBtn);
        commitBtn.setText("更新");
        commitBtn.setFont(font);
        commitBtn.setBounds(320,300,100,30);
        commitBtn.setBackground(new Color(80,150,230));
        this.add(commitBtn);

    }

    private void addListener(){

    }

}

