package com.liziczh.ims.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TabPanel extends JPanel{

    protected CardLayout card = new CardLayout(); // 卡片布局
    protected JLabel tabLabel = new JLabel(); // 标题Label
    protected JButton tabItem1Btn = new JButton(); // 选项卡1按钮
    protected JButton tabItem2Btn = new JButton(); // 选项卡2按钮
    protected JPanel tabContainerPanel = new JPanel(); // 选项卡容器面板
    protected JPanel tabItem1Panel = new JPanel(); // 选项卡1面板
    protected JPanel tabItem2Panel = new JPanel(); // 选项卡2面板

    public TabPanel(){
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

    private void addComponent(){

        // 侧栏Label
        tabLabel.setText("Sidebar");
        tabLabel.setBounds(15,20,120,40);
        tabLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        this.add(tabLabel);
        // 侧栏项1
        tabItem1Btn.setText("SidebarItem1");
        tabItem1Btn.setBackground(Color.white);
        tabItem1Btn.setFont(new Font("微软雅黑",Font.BOLD,14));
        tabItem1Btn.setBounds(15,80,120,30);
        this.add(tabItem1Btn);
        // 侧栏项2
        tabItem2Btn.setText("SidebarItem2");
        tabItem2Btn.setBackground(Color.white);
        tabItem2Btn.setFont(new Font("微软雅黑",Font.BOLD,14));
        tabItem2Btn.setBounds(15,130,120,30);
        this.add(tabItem2Btn);

        // 卡片容器面板
        tabContainerPanel.setLayout(card);
        tabContainerPanel.setBackground(Color.white);
        tabContainerPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        tabContainerPanel.setBounds(150,0,650,500);

        // 选项卡1面板
        tabItem1Panel.setLayout(null);
        tabItem1Panel.setBackground(Color.white);
        tabItem1Panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        tabItem1Panel.setBounds(0,0,600,500);
        tabContainerPanel.add("tabItem1Panel",tabItem1Panel);
        // 选项卡2面板
        tabItem2Panel.setLayout(null);
        tabItem2Panel.setBackground(Color.white);
        tabItem2Panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        tabItem2Panel.setBounds(0,0,600,500);
        tabContainerPanel.add("tabItem2Panel",tabItem2Panel);

        this.add(tabContainerPanel);


    }
    public void addListener(){
        tabItem1Btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                card.show(tabContainerPanel,"tabItem1Panel");
                tabItem1Btn.setBackground(new Color(214,213,183));
                tabItem2Btn.setBackground(Color.white);
            }
        });
        tabItem2Btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                card.show(tabContainerPanel,"tabItem2Panel");
                tabItem2Btn.setBackground(new Color(214,213,183));
                tabItem1Btn.setBackground(Color.white);
            }
        });

    }

}
