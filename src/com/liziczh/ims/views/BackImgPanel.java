package com.liziczh.ims.views;

import javax.swing.*;
import java.awt.*;

public class BackImgPanel extends JPanel {
    private Image img;

    public BackImgPanel(String imgPath) {
        img = new ImageIcon(imgPath).getImage();
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(img,0,0,null);
    }
}
