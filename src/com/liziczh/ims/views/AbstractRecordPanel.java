package com.liziczh.ims.views;

import com.liziczh.ims.domain.Record;
import com.liziczh.ims.tools.DateChooser;
import com.liziczh.ims.tools.DateUtils;
import com.liziczh.ims.tools.ListTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
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
    private String[] def = {"全部","家用电器","数码产品","电脑/办公","家居/家具","食品","图书","其他"};
    protected JComboBox dirBox = new JComboBox<>(def);
    // 查询
    private JButton queryBtn = new JButton();
    // record类型
    protected String recordType = "in";
    // 表格
    protected List<Record> recordList = new ArrayList<>();
    protected String[] colNames = {"日期", "产品编号", "产品名称", "数量", "登记人"};
    protected String[] propNames = {"date", "proId", "proName", "count", "register"};
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
        titleLabel.setBounds(50,20,120,40);
        titleLabel.setFont(new Font("微软雅黑",Font.BOLD,22));
        this.add(titleLabel);
        // 入库出库按钮
        stockBtn.setText("Stock I/O");
        stockBtn.setBounds(620,25,120,35);
        stockBtn.setBackground(Color.white);
        stockBtn.setFont(new Font("微软雅黑", Font.BOLD, 16));
        this.add(stockBtn);
        // 开始日期
        beginDateLabel.setText("日期：");
        beginDateLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        beginDateLabel.setBounds(50, 70, 60, 25);
        beginDateText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        beginDateText.setBounds(95, 70, 90, 25);
        beginDateText.setText(String.format("%tF", DateUtils.getFirstDayOfMethod()));
        beginDateText.setEditable(true);
        DateChooser.getInstance().register(this.beginDateText);
        this.add(beginDateLabel);
        this.add(beginDateText);
        // 结束日期
        endDateLabel.setText(" - ");
        endDateLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        endDateLabel.setBounds(185, 70, 20, 25);
        endDateText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        endDateText.setBounds(205, 70, 90, 25);
        endDateText.setEditable(true);
        endDateText.setText(String.format("%tF", new Date()));
        DateChooser.getInstance().register(this.endDateText);
        this.add(endDateLabel);
        this.add(endDateText);
        // 产品名称
        proNameLabel.setText("产品名称：");
        proNameLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        proNameLabel.setBounds(310, 70, 80, 25);
        proNameText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        proNameText.setBounds(390, 70, 100, 25);
        proNameText.setEditable(true);
        this.add(proNameLabel);
        this.add(proNameText);
        // 分类
        dirLabel.setText("分类：");
        dirLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        dirLabel.setBounds(500, 70, 60, 25);
        this.add(dirLabel);
        // 下拉框
        dirBox.setFont(new Font("微软雅黑", Font.BOLD, 14));
        dirBox.setBackground(Color.white);
        dirBox.setBounds(545,70,100,25);
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
    protected void setTable(){
        // 表格
        scrollPanel.setBounds(50,110,690,267);
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
        homePageBtn.setText("首页");
        homePageBtn.setBackground(Color.white);
        homePageBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
        homePageBtn.setBounds(50,390,80,25);
        this.add(homePageBtn);
        // 上一页
        prevPageBtn.setText("上一页");
        prevPageBtn.setBackground(Color.white);
        prevPageBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
        prevPageBtn.setBounds(300,390,80,25);
        this.add(prevPageBtn);
        // 下一页
        nextPageBtn.setText("下一页");
        nextPageBtn.setBackground(Color.white);
        nextPageBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
        nextPageBtn.setBounds(400,390,80,25);
        this.add(nextPageBtn);
        // 末页
        endPageBtn.setText("末页");
        endPageBtn.setBackground(Color.white);
        endPageBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
        endPageBtn.setBounds(660,390,80,25);
        this.add(endPageBtn);
    }

    private void addListener() {
        queryBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
    }


    public abstract void queryRecord();
    public abstract void homePage();
    public abstract void prevPage();
    public abstract void nextPage();
    public abstract void endPage();
}
