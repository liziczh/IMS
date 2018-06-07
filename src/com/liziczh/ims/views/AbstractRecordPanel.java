package com.liziczh.ims.views;

import com.liziczh.ims.domain.Record;
import com.liziczh.ims.tools.DateChooser;
import com.liziczh.ims.tools.DateUtils;
import com.liziczh.ims.tools.ListTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractRecordPanel extends JPanel {
    // 页面标签
    protected JLabel titleLabel = new JLabel();
    // 入库/出库按钮
    protected JButton stockBtn = new JButton();
    // 开始时间
    private JLabel beginDateLabel = new JLabel();
    protected JTextField beginDateText = new JTextField(6);
    // 结束时间
    private JLabel endDateLabel = new JLabel();
    protected JTextField endDateText = new JTextField(6);
    // 产品名称
    private JLabel proNameLabel = new JLabel();
    protected JTextField proNameText = new JTextField();
    // 分类
    private JLabel dirLabel = new JLabel();
    // 下拉框
    private String[] def = {"全部","食品酒水","家用电器","电脑办公","手机数码","家装厨具","图书音像","生活用品","其他"};
    protected JComboBox dirBox = new JComboBox<>(def);
    // 查询
    private JButton queryBtn = new JButton();

    // record类型
    protected String recordType = "in";
    // 表格
    protected List<Record> recordList = new ArrayList<>(); // 结果集
    protected int total = 0; // 总记录数
    protected String[] colNames = {"日期", "商品编号", "商品名称", "数量", "登记人"}; // 列名
    protected String[] propNames = {"date", "proId", "proName", "count", "register"}; // Record属性
    protected JTable recordTable = new JTable();
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
    // 导入
    protected JButton importBtn = new JButton();
    // 导出
    protected JButton exportBtn = new JButton();

    public AbstractRecordPanel(){
        this.init();
    }

    private void init(){
        this.setLayout(null);
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setBounds(0,100,800,500);
        this.addComponent();
        this.addListener();
    }

    private void addComponent() {
        // 页面标签
        titleLabel.setText("Stock I/O");
        titleLabel.setBounds(30,20,120,40);
        titleLabel.setFont(new Font("微软雅黑",Font.BOLD,22));
        this.add(titleLabel);
        // 入库出库按钮
        stockBtn.setText("Stock I/O");
        stockBtn.setBounds(600,25,120,35);
        stockBtn.setBackground(Color.white);
        stockBtn.setFont(new Font("微软雅黑", Font.BOLD, 16));
        this.add(stockBtn);
        // 开始日期
        beginDateLabel.setText("日期：");
        beginDateLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        beginDateLabel.setBounds(30, 70, 60, 25);
        beginDateText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        beginDateText.setBounds(75, 70, 90, 25);
        beginDateText.setText(String.format("%tF", DateUtils.getFirstDayOfMethod()));
        beginDateText.setBackground(Color.white);
        beginDateText.setEditable(false);
        DateChooser.getInstance().register(this.beginDateText);
        this.add(beginDateLabel);
        this.add(beginDateText);
        // 结束日期
        endDateLabel.setText(" - ");
        endDateLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        endDateLabel.setBounds(165, 70, 20, 25);
        endDateText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        endDateText.setBounds(185, 70, 90, 25);
        endDateText.setBackground(Color.white);
        endDateText.setEditable(false);
        endDateText.setText(String.format("%tF", new Date()));
        DateChooser.getInstance().register(this.endDateText);
        this.add(endDateLabel);
        this.add(endDateText);
        // 产品名称
        proNameLabel.setText("商品名称：");
        proNameLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        proNameLabel.setBounds(290, 70, 80, 25);
        proNameText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        proNameText.setBounds(370, 70, 100, 25);
        proNameText.setEditable(true);
        this.add(proNameLabel);
        this.add(proNameText);
        // 分类
        dirLabel.setText("分类：");
        dirLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        dirLabel.setBounds(480, 70, 60, 25);
        this.add(dirLabel);
        // 下拉框
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
    protected void setTable(){
        // 表格
        scrollPanel.setBounds(30,110,690,267);
        try {
            recordTable.setModel(new ListTableModel<>(recordList,Record.class,colNames,propNames));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 表格格式设置
        recordTable.setFont(new Font("微软雅黑",Font.PLAIN,14));
        recordTable.setRowHeight(24);
        recordTable.getTableHeader().setFont(new Font("微软雅黑",Font.BOLD,15));
        // 单元格居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        recordTable.setDefaultRenderer(Object.class, r);
        // 列编辑
        recordTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        recordTable.getTableHeader().setReorderingAllowed(false);//列不能移动
        // 添加表头表格
        scrollPanel.setViewportView(recordTable);
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

    private void addListener() {
        queryBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentPage = 1;
                pageNumText.setText(String.valueOf(currentPage));
                queryRecord();
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
                exportRecord();
            }
        });
        importBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                importRecord();
            }
        });

    }

    public abstract void queryRecord();
    public abstract void homePage();
    public abstract void prevPage();
    public abstract void nextPage();
    public abstract void endPage();
    public abstract void jumpPage();
    public abstract void exportRecord();
    public abstract void importRecord();

}
