package com.liziczh.ims.views;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InventoryQueryPanel extends JPanel {
    private Font font = new Font("微软雅黑", Font.BOLD, 14);
    // 产品名称
    private JLabel proNameLabel = new JLabel();
    private JTextField proNameText = new JTextField();
    // 库存量
    private JLabel countLowerLabel = new JLabel();
    private JTextField countLowerText = new JTextField(6);
    private JLabel countUpperLabel = new JLabel();
    private JTextField countUpperText = new JTextField(6);
    // 分类
    private JLabel dirLabel = new JLabel();
    // 查询
    private JButton queryBtn = new JButton();
    // 分类
    private String[] def = {"全部","家用电器","数码产品","电脑/办公","家居/家具","食品","图书"};
    private JComboBox dirBox = new JComboBox<>(def);
    // 表格
    private JTable purchaseInTable = new JTable();
    private JScrollPane scrollPanel = new JScrollPane();
    // 首页
    private JButton homePageBtn = new JButton();
    // 上一页
    private JButton prevPageBtn = new JButton();
    // 下一页
    private JButton nextPageBtn = new JButton();
    // 末页
    private JButton endPageBtn = new JButton();

    public InventoryQueryPanel(){
        this.init();
    }

    private void init(){
        this.setLayout(null);
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setBounds(0,0,650,500);
        this.addComponent();
        this.setVisible(true);
    }

    private void addComponent() {
        // 开始日期
        proNameLabel.setText("产品名称：");
        proNameLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        proNameLabel.setBounds(50, 25, 80, 25);
        proNameText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        proNameText.setBounds(120, 25, 80, 25);
        proNameText.setEditable(true);
        this.add(proNameLabel);
        this.add(proNameText);
        // 库存查询下限
        countLowerLabel.setText("库存：");
        countLowerLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        countLowerLabel.setBounds(210, 25, 60, 25);
        this.add(countLowerLabel);
        // 库存查询下限数值
        countLowerText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        countLowerText.setBounds(250, 25, 40, 25);
        countLowerText.setEditable(true);
        this.add(countLowerText);
        // 库存查询上限
        countUpperLabel.setText("-");
        countUpperLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        countUpperLabel.setBounds(295, 25, 20, 25);
        this.add(countUpperLabel);
        // 库存查询上限数值
        countUpperText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        countUpperText.setBounds(310, 25, 40, 25);
        countUpperText.setEditable(true);
        this.add(countUpperText);
        // 分类
        dirLabel.setText("分类：");
        dirLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        dirLabel.setBounds(360, 25, 80, 25);
        this.add(dirLabel);
        // 分类下拉框
        dirBox.setFont(new Font("微软雅黑", Font.BOLD, 14));
        dirBox.setBackground(Color.white);
        dirBox.setBounds(400,25,100,25);
        this.add(dirBox);
        // 查询按钮
        queryBtn.setText("查询");
        queryBtn.setBackground(Color.white);
        queryBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
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
    private void setTable(){
        // 表格
        scrollPanel.setBounds(50,70,540,231);
        Object[] colNames = {"产品编号", "产品名称", "分类","供应商", "商标","数量"};
        Object[][] data = {
                {1001, "罗技M90", "电脑/办公", "罗技", "罗技", 100},
                {1002, "罗技M100", "电脑/办公", "罗技", "罗技", 200},
                {1003, "罗技M115", "电脑/办公", "罗技", "罗技", 240},
                {1004, "罗技M125", "电脑/办公", "罗技", "罗技", 100},
                {1005, "罗技木星轨迹球", "电脑/办公", "罗技", "罗技", 50},
                {1006, "罗技火星轨迹球", "电脑/办公", "罗技", "罗技", 50},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
        };
        purchaseInTable.setModel(new DefaultTableModel(data, colNames));
        // 单元格居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        purchaseInTable.setDefaultRenderer(Object.class, r);
        // 列编辑
        purchaseInTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        purchaseInTable.getTableHeader().setReorderingAllowed(false);//列不能移动
        // 添加表头表格
        scrollPanel.setViewportView(purchaseInTable);
        this.add(scrollPanel);
    }


}
