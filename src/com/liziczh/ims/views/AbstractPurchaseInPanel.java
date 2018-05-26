package com.liziczh.ims.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AbstractPurchaseInPanel extends JPanel {

    private Font font = new Font("微软雅黑",Font.BOLD,14);
    private JLabel proId = new JLabel();
    protected JTextField proIdText = new JTextField();
    private JLabel proName = new JLabel();
    protected JTextField proNameText = new JTextField();
    private JLabel dirName = new JLabel();
    protected JTextField dirNameText = new JTextField();
    private JLabel supplier = new JLabel();
    protected JTextField supplierText = new JTextField();
    private JLabel brand = new JLabel();
    protected JTextField brandText = new JTextField();
    private JLabel count = new JLabel();
    protected JTextField countText = new JTextField();
    private JLabel register = new JLabel();
    protected JTextField registerText = new JTextField();
    protected JButton resetBtn = new JButton();
    protected JButton commitBtn = new JButton();
    protected String recordType = "in";

    public AbstractPurchaseInPanel(){
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
        dirName.setText("分   类 :");
        dirName.setFont(font);
        dirName.setBounds(150,120,100,30);
        this.add(dirName);
        dirNameText.setBounds(220,120,200,30);
        dirNameText.setFont(font);
        this.add(dirNameText);
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
        register.setText("负 责 人：");
        register.setFont(font);
        register.setBounds(150,280,100,30);
        this.add(register);
        registerText.setBounds(220,280,200,30);
        registerText.setFont(font);
        this.add(registerText);

        resetBtn.setText("重置");
        resetBtn.setFont(font);
        resetBtn.setBounds(150,320,100,30);
        resetBtn.setBackground(new Color(230,200,80));
        this.add(resetBtn);
        commitBtn.setText("提交");
        commitBtn.setFont(font);
        commitBtn.setBounds(320,320,100,30);
        commitBtn.setBackground(new Color(80,150,230));
        this.add(commitBtn);

    }

    protected void addListener(){

        //重置所有输入信息为空
        resetBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reset();
            }
        });

        //进货入库页面提交后，数据内容保存到数据库中的商品表中，并转到入库记录界面
        commitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(proIdText.getText() == null && proNameText.getText() == null && dirNameText.getText() == null && supplierText == null && brandText == null && countText == null && registerText == null){
                    JOptionPane.showMessageDialog(null,"请确认所有选项都已填写完成");
                }else{
                    commit();
//                    reset();
                }
            }
        });
    }
    public abstract void commit();
    public abstract void reset();

}

