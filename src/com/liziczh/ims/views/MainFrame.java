package com.liziczh.ims.views;

import com.liziczh.ims.controller.*;
import com.liziczh.ims.domain.Product;
import com.liziczh.ims.tools.ListTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

    private CardLayout card = new CardLayout(); // 卡片布局
    // 菜单栏组件
    private JPanel menuPanel = new JPanel(); // 菜单栏
    private JLabel logoLabel = new JLabel(); // logo
    private JButton stockInBtn = new JButton(); // 进货管理选项
    private JButton stockOutBtn = new JButton(); // 销售管理选项
    private JButton inventoryBtn = new JButton(); // 库存管理选项
    private JButton statisticsBtn = new JButton(); // 统计报表选项

    // 内容栏组件
    private JPanel contentPanel = new JPanel(); // 下栏容器
    private AbstractRecordPanel stockInPanel = new RecordController();// 进货管理页面
    private AbstractRecordPanel stockOutPanel = new RecordController();// 销售管理页面
    private AbstractInventoryPanel inventoryPanel = new InventoryController();// 库存管理页面
    private StatisticsPanel statisticsPanel = new StatisticsPanel();// 统计报表


    public MainFrame(){
        this.init();
    }

    private void init(){
        this.setTitle("进销存管理系统");
        this.setIconImage(new ImageIcon("imgs/logo.png").getImage());
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(Color.white);
        this.setLayout(null);
        this.addComponent();
        this.addListener();
        this.setVisible(true);

    }

    private void addComponent(){
        // 设置面板
        this.setMenuPanel();
        this.setContentPanel();
        // 主窗口添加面板
        this.getContentPane().add(menuPanel);
        this.getContentPane().add(contentPanel);
    }

    private void setMenuPanel(){
        // 菜单面板
        menuPanel.setLayout(null);
        menuPanel.setBackground(Color.white);
        menuPanel.setBounds(0,0,800,100);
        menuPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        menuPanel.add(new BackgroundImgPanel("imgs/menu.jpg"));
        // logo
        logoLabel.setText(" IMS");
        logoLabel.setIcon(new ImageIcon("imgs/logo32.png"));
        logoLabel.setFont(new Font("微软雅黑",Font.BOLD,30));
        logoLabel.setBounds(50,30,200,50);
        menuPanel.add(logoLabel);

        // 进货管理
        stockInBtn.setText("进货管理");
        stockInBtn.setFont(new Font("微软雅黑",Font.BOLD,16));
        stockInBtn.setIcon(new ImageIcon("imgs/in.png"));
        stockInBtn.setBackground(Color.white);
        stockInBtn.setBounds(200,30,120,50);
        menuPanel.add(stockInBtn);
        // 销售管理
        stockOutBtn.setText("销售管理");
        stockOutBtn.setFont(new Font("微软雅黑",Font.BOLD,16));
        stockOutBtn.setIcon(new ImageIcon("imgs/out.png"));
        stockOutBtn.setBackground(Color.white);
        stockOutBtn.setBounds(340,30,120,50);
        menuPanel.add(stockOutBtn);
        // 库存管理
        inventoryBtn.setText("库存管理");
        inventoryBtn.setFont(new Font("微软雅黑",Font.BOLD,16));
        inventoryBtn.setIcon(new ImageIcon("imgs/inventory.png"));
        inventoryBtn.setBackground(Color.white);
        inventoryBtn.setBounds(480,30,120,50);
        menuPanel.add(inventoryBtn);
        // 统计报表
        statisticsBtn.setText("统计报表");
        statisticsBtn.setFont(new Font("微软雅黑",Font.BOLD,16));
        statisticsBtn.setIcon(new ImageIcon("imgs/statistics.png"));
        statisticsBtn.setBackground(Color.white);
        statisticsBtn.setBounds(620,30,120,50);
        menuPanel.add(statisticsBtn);

    }

    private void setContentPanel(){
        // 下方面板Panel
        contentPanel.setLayout(card);
        contentPanel.setBackground(Color.white);
        contentPanel.setBounds(0,100,800,500);
        contentPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // 进货管理
        stockInPanel.titleLabel.setText("进货管理");
        stockInPanel.titleLabel.setIcon(new ImageIcon("imgs/right.png"));
        stockInPanel.stockBtn.setText("进货入库");
        stockInPanel.stockBtn.setIcon(new ImageIcon("imgs/in.png"));
        stockInPanel.recordType = "in";
        contentPanel.add("stockInPanel",stockInPanel);

        // 销售管理
        stockOutPanel.titleLabel.setText("销售管理");
        stockOutPanel.titleLabel.setIcon(new ImageIcon("imgs/right.png"));
        stockOutPanel.stockBtn.setText("销售出库");
        stockOutPanel.stockBtn.setIcon(new ImageIcon("imgs/out.png"));
        stockOutPanel.recordType = "out";
        contentPanel.add("stockOutPanel",stockOutPanel);

        // 库存管理
        inventoryPanel.titleLabel.setText("库存管理");
        inventoryPanel.titleLabel.setIcon(new ImageIcon("imgs/right.png"));
        contentPanel.add("inventoryPanel",inventoryPanel);

        // 统计报表
        statisticsPanel.titleLabel.setText("统计报表");
        statisticsPanel.titleLabel.setIcon(new ImageIcon("imgs/right.png"));
        contentPanel.add("statisticsPanel",statisticsPanel);
    }

    private void addListener(){
        /*
         * 页面切换
         */
        // 进货管理
        stockInBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                card.show(contentPanel,"stockInPanel");
                stockInPanel.queryRecord();
                // 按钮变色
                stockInBtn.setBackground(new Color(214,213,183));
                stockOutBtn.setBackground(Color.white);
                inventoryBtn.setBackground(Color.white);
                statisticsBtn.setBackground(Color.white);
            }
        });
        // 销售管理
        stockOutBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                card.show(contentPanel,"stockOutPanel");
                stockOutPanel.queryRecord();
                // 按钮变色
                stockInBtn.setBackground(Color.white);
                stockOutBtn.setBackground(new Color(214,213,183));
                inventoryBtn.setBackground(Color.white);
                statisticsBtn.setBackground(Color.white);
            }
        });
        // 库存管理
        inventoryBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                card.show(contentPanel,"inventoryPanel");
                inventoryPanel.queryProduct();
                // 按钮变色
                stockInBtn.setBackground(Color.white);
                stockOutBtn.setBackground(Color.white);
                inventoryBtn.setBackground(new Color(214,213,183));
                statisticsBtn.setBackground(Color.white);
            }
        });
        // 统计报表
        statisticsBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                card.show(contentPanel,"statisticsPanel");
                // 按钮变色
                stockInBtn.setBackground(Color.white);
                stockOutBtn.setBackground(Color.white);
                inventoryBtn.setBackground(Color.white);
                statisticsBtn.setBackground(new Color(214,213,183));
            }
        });
        // 进货入库
        stockInPanel.stockBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new StockInController();
            }
        });
        // 销售出库
        stockOutPanel.stockBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new StockOutController();
            }
        });
        // 商品管理
        inventoryPanel.inventoryMngBtn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(inventoryPanel.stockTable.getSelectedRow() == -1){
                    JOptionPane.showMessageDialog(null,"未选中任何商品","温馨提示",JOptionPane.WARNING_MESSAGE);
                }else{
                    AbstractInventoryMngDialog inventoryMngDialog= new InventoryMngController();
                    try {
                        inventoryMngDialog.product = new ListTableModel<>(inventoryPanel.proList,Product.class,inventoryPanel.colNames,inventoryPanel.propNames).getInstance(inventoryPanel.stockTable.getSelectedRow());
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    inventoryMngDialog.setText(inventoryMngDialog.product);
                }
            }
        });

    }



}