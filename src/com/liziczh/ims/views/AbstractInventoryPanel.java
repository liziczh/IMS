package com.liziczh.ims.views;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.domain.Record;
import com.liziczh.ims.tools.ListTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractInventoryPanel extends JPanel {
    private Font font = new Font("微软雅黑", Font.BOLD, 14);
    // 页面标签
    protected JLabel titleLabel = new JLabel();
    // 商品管理按钮
    protected JButton inventoryMngBtn = new JButton();
    // 产品名称
    private JLabel proNameLabel = new JLabel();
    protected JTextField proNameText = new JTextField();
    // 库存量
    private JLabel countLowerLabel = new JLabel();
    protected JTextField countLowerText = new JTextField(6);
    private JLabel countUpperLabel = new JLabel();
    protected JTextField countUpperText = new JTextField(6);
    // 分类
    private JLabel dirLabel = new JLabel();
    // 查询
    private JButton queryBtn = new JButton();
    // 分类
    private String[] def = {"全部","家用电器","数码产品","电脑/办公","家居/家具","食品","图书"};
    protected JComboBox dirBox = new JComboBox<>(def);
    // 表格
    protected List<Product> proList = new ArrayList<>();
    protected String[] colNames = {"产品编号", "产品名称", "分类","供应商", "商标","数量"};
    protected String[] propNames = {"proId", "proName", "dirName", "supplier", "brand","count"};
    protected JTable stockTable = new JTable();
    private JScrollPane scrollPanel = new JScrollPane();
    // 当前页数和页内数据行数
    protected int currentPage = 1;
    protected int pageSize = 10;
    // 首页
    private JButton homePageBtn = new JButton();
    // 上一页
    private JButton prevPageBtn = new JButton();
    // 下一页
    private JButton nextPageBtn = new JButton();
    // 末页
    private JButton endPageBtn = new JButton();

    public AbstractInventoryPanel(){
            this.init();
        }
    private void init(){
        this.setLayout(null);
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setBounds(0,100,800,500);
        this.addComponent();
        this.addListener();
        this.setVisible(true);
    }

    private void addComponent() {
        // 页面标签 Label
        titleLabel.setText("出/入库管理");
        titleLabel.setBounds(50,20,120,40);
        titleLabel.setFont(new Font("微软雅黑",Font.BOLD,22));
        this.add(titleLabel);
        // 商品管理按钮
        inventoryMngBtn.setText("商品管理");
        inventoryMngBtn.setBounds(620,25,120,35);
        inventoryMngBtn.setBackground(Color.white);
        inventoryMngBtn.setFont(new Font("微软雅黑", Font.BOLD, 16));
        this.add(inventoryMngBtn);
        // 产品名称
        proNameLabel.setText("产品名称：");
        proNameLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        proNameLabel.setBounds(50, 70, 80, 25);
        proNameText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        proNameText.setBounds(130, 70, 120, 25);
        proNameText.setEditable(true);
        this.add(proNameLabel);
        this.add(proNameText);
        // 库存查询下限
        countLowerLabel.setText("库存：");
        countLowerLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        countLowerLabel.setBounds(270, 70, 60, 25);
        this.add(countLowerLabel);
        // 库存查询下限数值
        countLowerText.setFont(new Font("微软雅黑", Font.BOLD, 16));
        countLowerText.setBounds(310, 70, 50, 25);
        countLowerText.setEditable(true);
        this.add(countLowerText);
        // 库存查询上限
        countUpperLabel.setText(" - ");
        countUpperLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        countUpperLabel.setBounds(360, 70, 20, 25);
        this.add(countUpperLabel);
        // 库存查询上限数值
        countUpperText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        countUpperText.setBounds(380, 70, 50, 25);
        countUpperText.setEditable(true);
        this.add(countUpperText);
        // 分类
        dirLabel.setText("分类：");
        dirLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        dirLabel.setBounds(490, 70, 60, 25);
        this.add(dirLabel);
        // 分类下拉框
        dirBox.setFont(new Font("微软雅黑", Font.BOLD, 14));
        dirBox.setBackground(Color.white);
        dirBox.setBounds(540,70,100,25);
        this.add(dirBox);
        // 查询按钮
        queryBtn.setText("查询");
        queryBtn.setBackground(Color.white);
        queryBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
        queryBtn.setBounds(660,70,80,25);
        this.add(queryBtn);
        // 添加表格
        this.setTable();

    }
    private void setTable(){
        // 表格
        scrollPanel.setBounds(50,110,690,267);
        try {
            stockTable.setModel(new ListTableModel<>(proList,Record.class,colNames,propNames));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 表格格式设置
        stockTable.setFont(new Font("微软雅黑",Font.PLAIN,14));
        stockTable.setRowHeight(24);
        stockTable.getTableHeader().setFont(new Font("微软雅黑",Font.BOLD,15));
        // 单元格居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        stockTable.setDefaultRenderer(Object.class, r);
        // 列编辑
        stockTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        stockTable.getTableHeader().setReorderingAllowed(false);//列不能移动
        // 添加表头表格
        scrollPanel.setViewportView(stockTable);
        this.add(scrollPanel);

        // 首页
        homePageBtn.setText("首页");
        homePageBtn.setBackground(Color.white);
        homePageBtn.setFont(font);
        homePageBtn.setBounds(50,390,80,25);
        this.add(homePageBtn);
        // 上一页
        prevPageBtn.setText("上一页");
        prevPageBtn.setBackground(Color.white);
        prevPageBtn.setFont(font);
        prevPageBtn.setBounds(300,390,80,25);
        this.add(prevPageBtn);
        // 下一页
        nextPageBtn.setText("下一页");
        nextPageBtn.setBackground(Color.white);
        nextPageBtn.setFont(font);
        nextPageBtn.setBounds(400,390,80,25);
        this.add(nextPageBtn);
        // 末页
        endPageBtn.setText("末页");
        endPageBtn.setBackground(Color.white);
        endPageBtn.setFont(font);
        endPageBtn.setBounds(660,390,80,25);
        this.add(endPageBtn);
    }
    private void addListener(){
        queryBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                queryProduct();
            }
        });
        homePageBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homePage();
            }
        });
        prevPageBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                prevPage();
            }
        });
        nextPageBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nextPage();
            }
        });
        endPageBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                endPage();
            }
        });
    }

    public abstract void queryProduct();
    public abstract void homePage();
    public abstract void prevPage();
    public abstract void nextPage();
    public abstract void endPage();

}

