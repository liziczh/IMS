package com.liziczh.ims.views;

import com.liziczh.ims.tools.DateChooser;
import com.liziczh.ims.tools.DateUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class StatisticsPanel extends JPanel {
    // 页面标签
    protected JLabel titleLabel = new JLabel();
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
    // 统计
    private JButton countBtn = new JButton();
    // record类型
    protected String recordType = "in";

    public StatisticsPanel(){
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
        // 页面标签
        titleLabel.setText("统计报表");
        titleLabel.setBounds(50,20,120,40);
        titleLabel.setFont(new Font("微软雅黑",Font.BOLD,22));
        this.add(titleLabel);
        // 开始日期
        beginDateLabel.setText("日 期：");
        beginDateLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        beginDateLabel.setBounds(50, 70, 60, 25);
        beginDateText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        beginDateText.setBounds(100, 70, 100, 25);
        beginDateText.setText(String.format("%tF", DateUtils.getFirstDayOfMethod()));
        beginDateText.setEditable(true);
        DateChooser.getInstance().register(this.beginDateText);
        this.add(beginDateLabel);
        this.add(beginDateText);
        // 结束日期
        endDateLabel.setText(" - ");
        endDateLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        endDateLabel.setBounds(200, 70, 20, 25);
        endDateText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        endDateText.setBounds(220, 70, 100, 25);
        endDateText.setEditable(true);
        endDateText.setText(String.format("%tF", new Date()));
        DateChooser.getInstance().register(this.endDateText);
        this.add(endDateLabel);
        this.add(endDateText);
        // 分类
        dirLabel.setText("分 类：");
        dirLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        dirLabel.setBounds(490, 70, 60, 25);
        this.add(dirLabel);
        // 下拉框
        dirBox.setFont(new Font("微软雅黑", Font.BOLD, 14));
        dirBox.setBackground(Color.white);
        dirBox.setBounds(540,70,100,25);
        this.add(dirBox);
        // 查询按钮
        countBtn.setText("查询");
        countBtn.setBackground(Color.white);
        countBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
        countBtn.setBounds(660,70,80,25);
        this.add(countBtn);

    }

    private void addListener() {

    }


}
