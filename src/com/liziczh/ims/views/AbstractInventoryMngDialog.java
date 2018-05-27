package com.liziczh.ims.views;

import com.liziczh.ims.domain.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AbstractInventoryMngDialog extends JDialog {

    private Font font = new Font("微软雅黑",Font.BOLD,14);
    private JLabel proIdLabel = new JLabel();
    protected JTextField proIdText = new JTextField();
    private JLabel proNameLabel = new JLabel();
    protected JTextField proNameText = new JTextField();
    private JLabel dirNameLabel = new JLabel();
    // 分类下拉框
    private String[] def = {"全部","家用电器","数码产品","电脑/办公","家居/家具","食品","图书","其他"};
    protected JComboBox dirBox = new JComboBox<>(def);
    private JLabel supplierLabel = new JLabel();
    protected JTextField supplierText = new JTextField();
    private JLabel brandLabel = new JLabel();
    protected JTextField brandText = new JTextField();
    private JButton resetBtn = new JButton();
    private JButton modifyBtn = new JButton();
    public Product product = new Product();

    public AbstractInventoryMngDialog(){
        this.init();
    }

    private void init(){
        this.setTitle("商品管理");
        this.getContentPane().setBackground(Color.white);
        this.setIconImage(new ImageIcon("imgs/logo.png").getImage());
        this.setSize(310,400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.addComponent();
        this.addListener();
        this.setVisible(true);
    }

    private void addComponent(){
        proIdLabel.setText("产品编号:");
        proIdLabel.setFont(font);
        proIdLabel.setBounds(20,40,100,30);
        this.add(proIdLabel);
        proIdText.setBounds(90,40,200,30);
        proIdText.setFont(font);
        this.add(proIdText);
        proNameLabel.setText("产品名称:");
        proNameLabel.setFont(font);
        proNameLabel.setBounds(20,80,100,30);
        this.add(proNameLabel);
        proNameText.setBounds(90,80,200,30);
        proNameText.setFont(font);
        this.add(proNameText);
        dirNameLabel.setText("分   类 :");
        dirNameLabel.setFont(font);
        dirNameLabel.setBounds(20,120,100,30);
        this.add(dirNameLabel);
        dirBox.setBounds(90,120,200,30);
        dirBox.setFont(font);
        dirBox.setBackground(Color.white);
        this.add(dirBox);
        supplierLabel.setText("供 应 商：");
        supplierLabel.setFont(font);
        supplierLabel.setBounds(20,160,100,30);
        this.add(supplierLabel);
        supplierText.setBounds(90,160,200,30);
        supplierText.setFont(font);
        this.add(supplierText);
        brandLabel.setText("产品商标:");
        brandLabel.setFont(font);
        brandLabel.setBounds(20,200,100,30);
        this.add(brandLabel);
        brandText.setBounds(90,200,200,30);
        brandText.setFont(font);
        this.add(brandText);
        resetBtn.setText("重置");
        resetBtn.setFont(font);
        resetBtn.setBounds(20,300,100,30);
        resetBtn.setBackground(new Color(230,200,80));
        this.add(resetBtn);
        modifyBtn.setText("修改");
        modifyBtn.setFont(font);
        modifyBtn.setBounds(180,300,100,30);
        modifyBtn.setBackground(new Color(80,150,230));
        this.add(modifyBtn);
    }
    public void setText(Product product){
        proIdText.setText(String.valueOf(product.getProId()));
        proNameText.setText(product.getProName());
        dirBox.setSelectedItem(product.getDirName());
        supplierText.setText(product.getSupplier());
        brandText.setText(product.getBrand());
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

