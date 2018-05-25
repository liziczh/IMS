package com.liziczh.ims.views;

import com.liziczh.ims.tools.DateChooser;
import com.liziczh.ims.tools.DateUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;

public class StatisticsPanel extends JPanel {
    private Font font = new Font("微软雅黑", Font.BOLD, 14);
    // 开始时间
    private JLabel beginDateLabel = new JLabel();
    private JTextField beginDateText = new JTextField(6);
    // 结束时间
    private JLabel endDateLabel = new JLabel();
    private JTextField endDateText = new JTextField(6);
    // 分类
    private JLabel dirLabel = new JLabel();
    // 下拉框
    private String[] def = {"全部","家用电器","数码产品","电脑/办公","家居/家具","食品","图书"};
    private JComboBox dir = new JComboBox<>(def);
    // 统计
    protected JButton countBtn = new JButton();

    public StatisticsPanel(){
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
        beginDateLabel.setText("起 始：");
        beginDateLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        beginDateLabel.setBounds(50, 25, 60, 25);
        beginDateText.setFont(font);
        beginDateText.setBounds(100, 25, 100, 25);
        beginDateText.setText(String.format("%tF", DateUtils.getFirstDayOfMethod()));
        beginDateText.setEditable(true);
        DateChooser.getInstance().register(this.beginDateText);
        this.add(beginDateLabel);
        this.add(beginDateText);
        // 结束日期
        endDateLabel.setText("至：");
        endDateLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        endDateLabel.setBounds(210, 25, 40, 25);
        endDateText.setFont(font);
        endDateText.setBounds(240, 25, 100, 25);
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
        dir.setFont(font);
        dir.setBackground(Color.white);
        dir.setBounds(400,25,100,25);
        this.add(dir);
        // 统计按钮
        countBtn.setText("统计");
        countBtn.setBackground(Color.white);
        countBtn.setFont(font);
        countBtn.setBounds(508,25,100,25);
        this.add(countBtn);

    }
    public void setTable(){

    }


}
