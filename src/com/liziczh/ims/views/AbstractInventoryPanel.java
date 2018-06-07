package com.liziczh.ims.views;

import com.liziczh.ims.domain.Product;
import com.liziczh.ims.domain.Record;
import com.liziczh.ims.tools.ListTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    private String[] def = {"全部","食品酒水","家用电器","电脑办公","手机数码","家装厨具","图书音像","生活用品","其他"};
    protected JComboBox dirBox = new JComboBox<>(def);
    // 表格
    public List<Product> proList = new ArrayList<>();
    protected int total = 0; // 总记录数
    public String[] colNames = {"商品编号", "商品名称", "分类","供应商", "商标","数量"};
    public String[] propNames = {"proId", "proName", "dirName", "supplier", "brand","count"};
    public JTable stockTable = new JTable();
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
    // 当前页数
    protected JTextField pageNumText = new JTextField();
    // 导出
    protected JButton exportBtn = new JButton();
    // 导入
    protected JButton importBtn = new JButton();

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
        titleLabel.setBounds(30,20,120,40);
        titleLabel.setFont(new Font("微软雅黑",Font.BOLD,22));
        this.add(titleLabel);
        // 商品管理按钮
        inventoryMngBtn.setText("商品管理");
        inventoryMngBtn.setIcon(new ImageIcon("imgs/management.png"));
        inventoryMngBtn.setBounds(600,25,120,35);
        inventoryMngBtn.setBackground(Color.white);
        inventoryMngBtn.setFont(new Font("微软雅黑", Font.BOLD, 16));
        this.add(inventoryMngBtn);
        // 产品名称
        proNameLabel.setText("商品名称：");
        proNameLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        proNameLabel.setBounds(30, 70, 80, 25);
        proNameText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        proNameText.setBounds(110, 70, 120, 25);
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
        dirLabel.setBounds(480, 70, 60, 25);
        this.add(dirLabel);
        // 分类下拉框
        dirBox.setFont(new Font("微软雅黑", Font.BOLD, 14));
        dirBox.setBackground(Color.white);
        dirBox.setBounds(525,70,100,25);
        this.add(dirBox);
        // 查询按钮
        queryBtn.setText("查询");
        queryBtn.setIcon(new ImageIcon("imgs/soso.png"));
        queryBtn.setBackground(Color.white);
        queryBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
        queryBtn.setBounds(630,70,90,25);
        this.add(queryBtn);
        // 添加表格
        this.setTable();

    }
    private void setTable(){
        // 表格
        scrollPanel.setBounds(30,110,690,267);
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
        homePageBtn.setIcon(new ImageIcon("imgs/home.png"));
        homePageBtn.setBackground(Color.white);
        homePageBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
        homePageBtn.setBounds(30,390,50,25);
        this.add(homePageBtn);
        // 上一页
        prevPageBtn.setIcon(new ImageIcon("imgs/left.png"));
        prevPageBtn.setBackground(Color.white);
        prevPageBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
        prevPageBtn.setBounds(300,390,50,25);
        this.add(prevPageBtn);
        // 页数
        pageNumText.setText(String.valueOf(currentPage));
        pageNumText.setBackground(Color.white);
        pageNumText.setHorizontalAlignment(JTextField.CENTER);
        pageNumText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        pageNumText.setBounds(360,390,30,25);
        this.add(pageNumText);
        // 下一页
        nextPageBtn.setIcon(new ImageIcon("imgs/right.png"));
        nextPageBtn.setBackground(Color.white);
        nextPageBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
        nextPageBtn.setBounds(400,390,50,25);
        this.add(nextPageBtn);
        // 末页
        endPageBtn.setIcon(new ImageIcon("imgs/end.png"));
        endPageBtn.setBackground(Color.white);
        endPageBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
        endPageBtn.setBounds(670,390,50,25);
        this.add(endPageBtn);
        // 导出
        exportBtn.setIcon(new ImageIcon("imgs/export.png"));
        exportBtn.setBackground(Color.white);
        exportBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
        exportBtn.setBounds(720,110,25,25);
        this.add(exportBtn);
        // 导入
        importBtn.setIcon(new ImageIcon("imgs/import.png"));
        importBtn.setBackground(Color.white);
        importBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
        importBtn.setBounds(720,135,25,25);
        this.add(importBtn);
    }
    private void addListener(){
        queryBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 先将页数置1
                currentPage = 1;
                pageNumText.setText(String.valueOf(currentPage));
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
//        pageNumText.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseExited(MouseEvent e) {
//                jumpPage();
//            }
//        });
        pageNumText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    jumpPage();
                }
            }
        });
        exportBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exportProduct();
            }
        });
        importBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                importProduct();
            }
        });

    }

    public abstract void queryProduct();
    public abstract void homePage();
    public abstract void prevPage();
    public abstract void nextPage();
    public abstract void endPage();
    public abstract void jumpPage();
    public abstract void exportProduct();
    public abstract void importProduct();
}

