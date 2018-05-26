package com.liziczh.ims.views;

import com.liziczh.ims.domain.Record;
import com.liziczh.ims.tools.DateChooser;
import com.liziczh.ims.tools.DateUtils;
import com.liziczh.ims.tools.ListTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractRecordPanel extends JPanel {
    private Font font = new Font("微软雅黑", Font.BOLD, 14);
    // 开始时间
    private JLabel beginDateLabel = new JLabel();
    protected JTextField beginDateText = new JTextField(6);
    // 结束时间
    private JLabel endDateLabel = new JLabel();
    protected JTextField endDateText = new JTextField(6);
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
        this.setBounds(0,0,650,500);
        this.addComponent();
        this.addListener();
    }

    private void addComponent() {
        // 开始日期
        beginDateLabel.setText("日期：");
        beginDateLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        beginDateLabel.setBounds(50, 25, 60, 25);
        beginDateText.setFont(font);
        beginDateText.setBounds(100, 25, 90, 25);
        beginDateText.setText(String.format("%tF", DateUtils.getFirstDayOfMethod()));
        beginDateText.setEditable(true);
        DateChooser.getInstance().register(this.beginDateText);
        this.add(beginDateLabel);
        this.add(beginDateText);
        // 结束日期
        endDateLabel.setText("-");
        endDateLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        endDateLabel.setBounds(195, 25, 20, 25);
        endDateText.setFont(font);
        endDateText.setBounds(210, 25, 90, 25);
        endDateText.setEditable(true);
        endDateText.setText(String.format("%tF", new Date()));
        DateChooser.getInstance().register(this.endDateText);
        this.add(endDateLabel);
        this.add(endDateText);
        // 分类
        dirLabel.setText("分类：");
        dirLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        dirLabel.setBounds(350, 25, 60, 25);
        this.add(dirLabel);
        // 下拉框
        dirBox.setFont(font);
        dirBox.setBackground(Color.white);
        dirBox.setBounds(400,25,100,25);
        this.add(dirBox);
        // 查询按钮
        queryBtn.setText("查询");
        queryBtn.setBackground(Color.white);
        queryBtn.setFont(font);
        queryBtn.setBounds(508,25,80,25);
        this.add(queryBtn);

        // 添加表格
        this.setTable();

        // 首页
        homePageBtn.setText("首页");
        homePageBtn.setBackground(Color.lightGray);
        homePageBtn.setFont(font);
        homePageBtn.setBounds(50,310,80,25);
        this.add(homePageBtn);
        // 上一页
        prevPageBtn.setText("上一页");
        prevPageBtn.setBackground(Color.lightGray);
        prevPageBtn.setFont(font);
        prevPageBtn.setBounds(230,310,80,25);
        this.add(prevPageBtn);
        // 下一页
        nextPageBtn.setText("下一页");
        nextPageBtn.setBackground(Color.lightGray);
        nextPageBtn.setFont(font);
        nextPageBtn.setBounds(330,310,80,25);
        this.add(nextPageBtn);
        // 末页
        endPageBtn.setText("末页");
        endPageBtn.setBackground(Color.lightGray);
        endPageBtn.setFont(font);
        endPageBtn.setBounds(508,310,80,25);
        this.add(endPageBtn);

    }
    protected void setTable(){
        // 表格
        scrollPanel.setBounds(50,70,540,231);
        try {
            recordTable.setModel(new ListTableModel<Record>(recordList,Record.class,colNames,propNames));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    }

    private void addListener(){
        queryBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                queryRecord();
            }
        });
    }
    public abstract void queryRecord();


}
