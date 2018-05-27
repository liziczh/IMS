package com.liziczh.ims.views;

import com.liziczh.ims.controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

    private CardLayout card = new CardLayout(); // 卡片布局
    // 菜单栏组件
    private JPanel menuPanel = new JPanel(); // 菜单栏
    private JLabel logoLabel = new JLabel(); // logo
    private JButton purchaseBtn = new JButton(); // 进货管理选项
    private JButton salesBtn = new JButton(); // 销售管理选项
    private JButton inventoryBtn = new JButton(); // 库存管理选项
    private JButton statisticsBtn = new JButton(); // 统计报表选项

    // 侧栏组件
    private JPanel tabPanel = new JPanel(); // 侧栏容器
    private TabPanel purchasePanel = new TabPanel(); // 进货管理页面
    private TabPanel salesPanel = new TabPanel(); // 销售管理页面
    private TabPanel inventoryPanel = new TabPanel(); // 库存管理页面
    private TabPanel statisticsPanel = new TabPanel(); // 统计报表页面

    // 操作界面组件
    // purchasePanel界面内容
    private AbstractPurchaseInPanel purchaseInPanel = new PurchaseInController(); // 进货入库页面
    private AbstractRecordPanel purchaseRecordPanel = new RecordController(); // 入库记录页面
    // salesPanel界面内容
    private AbstractSalesOutPanel salesOutPanel = new SalesOutController(); // 销售出库页面
    private AbstractRecordPanel salesRecordPanel = new RecordController(); // 出库记录页面
    // inventoryPanel界面内容
    private AbstractInventoryQueryPanel inventoryQueryPanel = new InventoryQueryController(); // 查询库存页面
    private AbstractInventoryMngPanel inventoryMngPanel = new InventoryMngController(); // 库存更新界面
    // statistics界面内容
    private StatisticsPanel statisticsPurchasePanel = new StatisticsPanel();
    private StatisticsPanel statisticsSalesPanel = new StatisticsPanel();

    public MainFrame(){
        this.init();
    }

    private void init(){
        this.setTitle("进销存管理系统");
        this.setIconImage(new ImageIcon("imgs/logo.png").getImage());
        this.setSize(800,500);
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
        this.setSidebarPanel();
        // 主窗口添加面板
        this.getContentPane().add(menuPanel);
        this.getContentPane().add(tabPanel);
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
        logoLabel.setBounds(20,30,200,50);
        menuPanel.add(logoLabel);

        // 进货管理
        purchaseBtn.setText("进货管理");
        purchaseBtn.setFont(new Font("微软雅黑",Font.BOLD,16));
        purchaseBtn.setIcon(new ImageIcon("imgs/in.png"));
        purchaseBtn.setBackground(Color.white);
        purchaseBtn.setBounds(200,30,120,50);
        menuPanel.add(purchaseBtn);
        // 销售管理
        salesBtn.setText("销售管理");
        salesBtn.setFont(new Font("微软雅黑",Font.BOLD,16));
        salesBtn.setIcon(new ImageIcon("imgs/out.png"));
        salesBtn.setBackground(Color.white);
        salesBtn.setBounds(340,30,120,50);
        menuPanel.add(salesBtn);
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

    private void setSidebarPanel(){
        // 下方面板Panel
        tabPanel.setLayout(card);
        tabPanel.setBackground(Color.white);
        tabPanel.setBounds(0,100,800,400);
        tabPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // 进货管理
        purchasePanel.tabLabel.setText("进货管理");
        purchasePanel.tabLabel.setIcon(new ImageIcon("imgs/right.png"));
        purchasePanel.tabItem1Btn.setText("进货入库");
        purchasePanel.tabItem1Btn.setIcon(new ImageIcon("imgs/in.png"));
        purchasePanel.tabItem2Btn.setText("入库记录");
        purchasePanel.tabItem2Btn.setIcon(new ImageIcon("imgs/record.png"));
        tabPanel.add("purchasePanel",purchasePanel);

        // 销售管理
        salesPanel.tabLabel.setText("销售管理");
        salesPanel.tabLabel.setIcon(new ImageIcon("imgs/right.png"));
        salesPanel.tabItem1Btn.setText("销售出库");
        salesPanel.tabItem1Btn.setIcon(new ImageIcon("imgs/out.png"));
        salesPanel.tabItem2Btn.setText("出库记录");
        salesPanel.tabItem2Btn.setIcon(new ImageIcon("imgs/record.png"));
        tabPanel.add("salesPanel",salesPanel);
        // 库存管理
        inventoryPanel.tabLabel.setText("库存管理");
        inventoryPanel.tabLabel.setIcon(new ImageIcon("imgs/right.png"));
        inventoryPanel.tabItem1Btn.setText("查询库存");
        inventoryPanel.tabItem1Btn.setIcon(new ImageIcon("imgs/search.png"));
        inventoryPanel.tabItem2Btn.setText("商品管理");
        inventoryPanel.tabItem2Btn.setIcon(new ImageIcon("imgs/management.png"));
        tabPanel.add("inventoryPanel",inventoryPanel);
        // 统计报表
        statisticsPanel.tabLabel.setText("统计报表");
        statisticsPanel.tabLabel.setIcon(new ImageIcon("imgs/right.png"));
        statisticsPanel.tabItem1Btn.setText("采购统计");
        statisticsPanel.tabItem1Btn.setIcon(new ImageIcon("imgs/purchase.png"));
        statisticsPanel.tabItem2Btn.setText("销售统计");
        statisticsPanel.tabItem2Btn.setIcon(new ImageIcon("imgs/sales.png"));
        tabPanel.add("statisticsPanel",statisticsPanel);
        // --------------------------------------------------------------------------------------
        // 进货入库页面
        purchasePanel.tabItem1Panel.add("purchaseInPanel",purchaseInPanel);
        // 入库记录页面
        purchaseRecordPanel.colNames[0] = "入库日期";
        purchaseRecordPanel.recordType = "in";
        purchaseRecordPanel.setTable();
        purchasePanel.tabItem2Panel.add("purchaseRecordPanel",purchaseRecordPanel);

        // 销售出库页面
        salesPanel.tabItem1Panel.add("salesOutPanel",salesOutPanel);
        // 出库记录界面
        salesRecordPanel.colNames[0] = "出库日期";
        salesRecordPanel.recordType = "out";
        salesRecordPanel.setTable();
        salesPanel.tabItem2Panel.add("salesRecordPanel",salesRecordPanel);

        // 查询库存
        inventoryPanel.tabItem1Panel.add("inventoryQueryPanel",inventoryQueryPanel);
        // 商品管理
        inventoryPanel.tabItem2Panel.add("inventoryMngPanel",inventoryMngPanel);


        // 采购统计
        statisticsPurchasePanel.countBtn.setText("采购统计");
        statisticsPanel.tabItem1Panel.add("statisticsPurchasePanel",statisticsPurchasePanel);
        // 销售统计
        statisticsSalesPanel.countBtn.setText("销售统计");
        statisticsPanel.tabItem2Panel.add("statisticsSalesPanel",statisticsSalesPanel);

    }

    private void addListener(){
        /*
         * 页面切换
         */
        // 进货管理
        purchaseBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                card.show(tabPanel,"purchasePanel");
                purchasePanel.card.show(purchasePanel.tabContainerPanel,"purchaseInPanel");
                purchaseBtn.setBackground(new Color(214,213,183));
                salesBtn.setBackground(Color.white);
                inventoryBtn.setBackground(Color.white);
                statisticsBtn.setBackground(Color.white);
            }
        });
        // 销售管理
        salesBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                card.show(tabPanel,"salesPanel");
                salesPanel.card.show(salesPanel.tabContainerPanel,"salesOutPanel");
                purchaseBtn.setBackground(Color.white);
                salesBtn.setBackground(new Color(214,213,183));
                inventoryBtn.setBackground(Color.white);
                statisticsBtn.setBackground(Color.white);
            }
        });
        // 库存管理
        inventoryBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                card.show(tabPanel,"inventoryPanel");
                inventoryPanel.card.show(inventoryPanel.tabContainerPanel,"inventoryQueryPanel");
                purchaseBtn.setBackground(Color.white);
                salesBtn.setBackground(Color.white);
                inventoryBtn.setBackground(new Color(214,213,183));
                statisticsBtn.setBackground(Color.white);
            }
        });
        // 统计报表
        statisticsBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                card.show(tabPanel,"statisticsPanel");
                statisticsPanel.card.show(statisticsPanel.tabContainerPanel,"statisticsPurchasePanel");
                purchaseBtn.setBackground(Color.white);
                salesBtn.setBackground(Color.white);
                inventoryBtn.setBackground(Color.white);
                statisticsBtn.setBackground(new Color(214,213,183));
            }
        });


    }



}