package com.liziczh.ims.views;

import com.liziczh.ims.controller.*;
import com.liziczh.ims.domain.Product;
import com.liziczh.ims.tools.ListTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AbstractMainFrame extends JFrame {

    private CardLayout card = new CardLayout(); // 卡片布局
    // 菜单栏组件
    private BackImgPanel menuPanel = new BackImgPanel("imgs/mainbg4.jpg"); // 菜单栏
    private JLabel logoLabel = new JLabel(); // logo
    private JLabel logoTestLabel = new JLabel(); // logo文本
    private JLabel userLabel = new JLabel(); // 当前账户
    private String username; // 用户名
    private JLabel exitLabel = new JLabel(); // 退出登录
    private JButton stockInBtn = new JButton(); // 进货管理选项
    private JButton stockOutBtn = new JButton(); // 销售管理选项
    private JButton inventoryBtn = new JButton(); // 库存管理选项
    private JButton statisticsBtn = new JButton(); // 统计报表选项

    // 内容栏组件
    private JPanel contentPanel = new JPanel(); // 下栏容器
    public AbstractRecordPanel stockInPanel = new RecordController();// 进货管理页面
    private AbstractRecordPanel stockOutPanel = new RecordController();// 销售管理页面
    protected AbstractInventoryPanel inventoryPanel = new InventoryController();// 库存管理页面
    private AbstractStatisticsPanel statisticsPanel = new StatisticsController();// 统计报表


    public AbstractMainFrame(String username){
        this.username = username;
        this.init();
    }

    private void init(){
        this.setTitle("IMS");
        this.setIconImage(new ImageIcon("imgs/logo.png").getImage());
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.white);
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
        menuPanel.add(contentPanel);
        this.getContentPane().add(menuPanel);
    }

    private void setMenuPanel(){
        // 菜单面板
        menuPanel.setLayout(null);
        menuPanel.setBackground(Color.white);
        menuPanel.setBounds(0,0,800,600);
        menuPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // logo
        logoLabel.setIcon(new ImageIcon("imgs/logo32.png"));
        logoLabel.setBounds(50,30,50,50);
        menuPanel.add(logoLabel);

        // logo文本
        logoTestLabel.setText("IMS");
        logoTestLabel.setFont(new Font("微软雅黑",Font.BOLD,30));
        logoTestLabel.setBounds(110,30,80,50);
        menuPanel.add(logoTestLabel);

        // 当前账户
        userLabel.setText("用户："+username);
        userLabel.setFont(new Font("微软雅黑",Font.BOLD,14));
        userLabel.setBounds(730-username.length()*10,2,50+username.length()*10,20);
        menuPanel.add(userLabel);

        // 退出登录
        exitLabel.setIcon(new ImageIcon("imgs/exit.png"));
        exitLabel.setBounds(770,2,20,20);
        menuPanel.add(exitLabel);

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
        contentPanel.setBounds(20,100,755,450);
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
                // 切换页面
                card.show(contentPanel,"stockInPanel");
                // 页面初始化
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
                // 切换页面
                card.show(contentPanel,"stockOutPanel");
                // 页面初始化
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
                // 切换页面
                card.show(contentPanel,"inventoryPanel");
                // 页面初始化
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
                // 切换页面
                card.show(contentPanel,"statisticsPanel");
                // 页面初始化
                statisticsPanel.setShape();
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
                // 入库表单初始化
                AbstractStockIODialog stockInDialog =  new StockIOController();
                stockInDialog.titleLabel.setText("进货入库");
                stockInDialog.recordType = "in";
                stockInDialog.add(stockInDialog.stockInBtn);

            }
        });
        // 销售出库
        stockOutPanel.stockBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 出库表单初始化
                AbstractStockIODialog stockOutDialog =  new StockIOController();
                stockOutDialog.titleLabel.setText("销售出库");
                stockOutDialog.recordType = "out";
                stockOutDialog.add(stockOutDialog.stockOutBtn);
            }
        });
        // 商品管理
        inventoryPanel.inventoryMngBtn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                inventoryMng();
            }
        });

        // 退出登录
        exitLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exit();
            }
        });

    }
    public abstract void exit();
    public abstract void inventoryMng();


}