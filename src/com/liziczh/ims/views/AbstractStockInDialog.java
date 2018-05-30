package com.liziczh.ims.views;

import com.liziczh.ims.domain.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AbstractStockInDialog extends JDialog {

    private Font font = new Font("微软雅黑",Font.BOLD,14);
    private JLabel titleLabel = new JLabel();
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
    private JLabel countLabel = new JLabel();
    protected JTextField countText = new JTextField();
    private JLabel registerLabel = new JLabel();
    protected JTextField registerText = new JTextField();
    protected JButton resetBtn = new JButton();
    protected JButton inStockBtn = new JButton();
    protected String recordType = "in";

    public AbstractStockInDialog(){
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
        titleLabel.setText("进货入库");
        titleLabel.setIcon(new ImageIcon("imgs/in.png"));
        titleLabel.setFont(new Font("微软雅黑",Font.PLAIN,20));
        titleLabel.setBounds(120,20,120,40);
        this.add(titleLabel);
        proIdLabel.setText("产品编号:");
        proIdLabel.setFont(font);
        proIdLabel.setBounds(40,80,100,30);
        this.add(proIdLabel);
        proIdText.setBounds(110,80,200,30);
        proIdText.setFont(font);
        this.add(proIdText);
        proNameLabel.setText("产品名称:");
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
        countLabel.setText("产品数量:");
        countLabel.setFont(font);
        countLabel.setBounds(40,280,100,30);
        this.add(countLabel);
        countText.setBounds(110,280,200,30);
        countText.setFont(font);
        this.add(countText);
        registerLabel.setText("负 责 人：");
        registerLabel.setFont(font);
        registerLabel.setBounds(40,320,100,30);
        this.add(registerLabel);
        registerText.setBounds(110,320,200,30);
        registerText.setFont(font);
        this.add(registerText);

        resetBtn.setText("重置");
        resetBtn.setFont(font);
        resetBtn.setBounds(40,380,100,30);
        resetBtn.setBackground(new Color(230,200,80));
        this.add(resetBtn);
        inStockBtn.setText("入库");
        inStockBtn.setFont(font);
        inStockBtn.setBounds(200,380,100,30);
        inStockBtn.setBackground(new Color(80,150,230));
        this.add(inStockBtn);

    }

    protected void addListener(){
        // 输入ID自动补全
        proIdText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                autoComplete();
            }
        });

        // 重置所有输入信息为空
        resetBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reset();
            }
        });

        // 进货入库页面提交后，数据内容保存到数据库中的商品表中，并转到入库记录界面
        inStockBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                stockIn();
            }
        });
    }

    public abstract void reset();
    public abstract void stockIn();
    public abstract void autoComplete();
}

