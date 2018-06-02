package com.liziczh.ims.views;

import com.liziczh.ims.tools.DateChooser;
import com.liziczh.ims.tools.DateUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractStatisticsPanel extends JPanel {
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
    private String[] def = {"采购","销售"};
    protected JComboBox dirBox = new JComboBox<>(def);
    // 统计
    private JButton countBtn = new JButton();
    // record类型
    protected String recordType = null;
    // 统计图
    protected JPanel shapePanel = new JPanel();
    //图片label
    protected JLabel shapeLabel = new JLabel();

    public AbstractStatisticsPanel(){
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
        titleLabel.setBounds(30,20,120,40);
        titleLabel.setFont(new Font("微软雅黑",Font.BOLD,22));
        this.add(titleLabel);
        // 开始日期
        beginDateLabel.setText("日 期：");
        beginDateLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        beginDateLabel.setBounds(30, 70, 60, 25);
        beginDateText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        beginDateText.setBounds(80, 70, 100, 25);
        beginDateText.setText(String.format("%tF", DateUtils.getFirstDayOfMethod()));
        beginDateText.setBackground(Color.white);
        beginDateText.setEditable(false);
        DateChooser.getInstance().register(this.beginDateText);
        this.add(beginDateLabel);
        this.add(beginDateText);
        // 结束日期
        endDateLabel.setText(" - ");
        endDateLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        endDateLabel.setBounds(180, 70, 20, 25);
        endDateText.setFont(new Font("微软雅黑", Font.BOLD, 14));
        endDateText.setBounds(200, 70, 100, 25);
        endDateText.setBackground(Color.white);
        endDateText.setEditable(false);
        endDateText.setText(String.format("%tF", new Date()));
        DateChooser.getInstance().register(this.endDateText);
        this.add(endDateLabel);
        this.add(endDateText);
        // 分类
        dirLabel.setText("统计类型：");
        dirLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        dirLabel.setBounds(460, 70, 100, 25);
        this.add(dirLabel);
        // 下拉框
        dirBox.setFont(new Font("微软雅黑", Font.BOLD, 14));
        dirBox.setBackground(Color.white);
        dirBox.setBounds(560,70,60,25);
        this.add(dirBox);
        // 统计按钮
        countBtn.setText("统计");
        countBtn.setBackground(Color.white);
        countBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
        countBtn.setBounds(640,70,80,25);
        this.add(countBtn);
        // 统计图
        shapePanel.setBackground(Color.white);
        shapePanel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        shapePanel.setBounds(30,110,690,320);
        shapePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        shapePanel.setVisible(true);
        this.add(shapePanel);
        //图片的显示
        shapeLabel.setBounds(30,110,690,320);
        shapePanel.add(shapeLabel);
    }
    //添加监听事件
    public void addListener() {
        countBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setShape();
            }
        });
    }
    //设置图片内容
    public abstract void setShape();

}
