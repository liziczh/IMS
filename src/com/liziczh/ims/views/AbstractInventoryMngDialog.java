package com.liziczh.ims.views;

import com.liziczh.ims.domain.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AbstractInventoryMngDialog extends JDialog {

    private Font font = new Font("微软雅黑",Font.BOLD,14);
    private JLabel titleLabel = new JLabel();
    private JLabel proIdLabel = new JLabel();
    protected JTextField proIdText = new JTextField();
    private JLabel proNameLabel = new JLabel();
    protected JTextField proNameText = new JTextField();
    private JLabel dirNameLabel = new JLabel();
    // 分类下拉框
    private String[] def = {"全部","食品酒水","家用电器","电脑办公","手机数码","家装厨具","图书音像","生活用品","其他"};
    protected JComboBox dirBox = new JComboBox<>(def);
    private JLabel supplierLabel = new JLabel();
    protected JTextField supplierText = new JTextField();
    private JLabel brandLabel = new JLabel();
    protected JTextField brandText = new JTextField();
    private JButton resetBtn = new JButton();
    private JButton modifyBtn = new JButton();
    // 商品显示信息的封装
    public Product product = new Product();

    public AbstractInventoryMngDialog(){
        this.init();
    }

    private void init(){
        titleLabel.setText("商品管理");
        titleLabel.setIcon(new ImageIcon("imgs/in.png"));
        titleLabel.setFont(new Font("微软雅黑",Font.PLAIN,20));
        titleLabel.setBounds(120,20,120,40);
        this.add(titleLabel);
        this.setTitle("商品管理");
        this.getContentPane().setBackground(Color.white);
        this.setIconImage(new ImageIcon("imgs/logo.png").getImage());
        this.setSize(360,400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.addComponent();
        this.addListener();
        this.setVisible(true);
    }

    private void addComponent(){
        proIdLabel.setText("商品编号:");
        proIdLabel.setFont(font);
        proIdLabel.setBounds(40,80,100,30);
        this.add(proIdLabel);
        proIdText.setBounds(110,80,200,30);
        proIdText.setFont(font);
        proIdText.setEditable(false);
        proIdText.setBackground(Color.white);
        this.add(proIdText);
        proNameLabel.setText("商品名称:");
        proNameLabel.setFont(font);
        proNameLabel.setBounds(40,120,100,30);
        this.add(proNameLabel);
        proNameText.setBounds(110,120,200,30);
        proNameText.setFont(font);
        this.add(proNameText);
        dirNameLabel.setText("分   类 :");
        dirNameLabel.setFont(font);
        dirNameLabel.setBounds(40,160,100,30);
        this.add(dirNameLabel);
        dirBox.setBounds(110,160,200,30);
        dirBox.setFont(font);
        dirBox.setBackground(Color.white);
        this.add(dirBox);
        supplierLabel.setText("供 应 商：");
        supplierLabel.setFont(font);
        supplierLabel.setBounds(40,200,100,30);
        this.add(supplierLabel);
        supplierText.setBounds(110,200,200,30);
        supplierText.setFont(font);
        this.add(supplierText);
        brandLabel.setText("产品商标:");
        brandLabel.setFont(font);
        brandLabel.setBounds(40,240,100,30);
        this.add(brandLabel);
        brandText.setBounds(110,240,200,30);
        brandText.setFont(font);
        this.add(brandText);
        resetBtn.setText("重置");
        resetBtn.setFont(font);
        resetBtn.setBounds(40,300,100,30);
        resetBtn.setBackground(new Color(230,200,80));
        this.add(resetBtn);
        modifyBtn.setText("修改");
        modifyBtn.setFont(font);
        modifyBtn.setBounds(200,300,100,30);
        modifyBtn.setBackground(new Color(80,150,230));
        this.add(modifyBtn);
    }
    public void setText(Product product){
        if(product != null){
            proIdText.setText(String.valueOf(product.getProId()));
            proNameText.setText(product.getProName());
            dirBox.setSelectedItem(product.getDirName());
            supplierText.setText(product.getSupplier());
            brandText.setText(product.getBrand());
        }
    }

    private void addListener(){
        resetBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reset();
            }
        });
        modifyBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modify();
            }
        });
    }


    public abstract void reset();
    public abstract void modify();

}

