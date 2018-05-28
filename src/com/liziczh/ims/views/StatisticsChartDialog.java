package com.liziczh.ims.views;

import com.liziczh.ims.tools.GUITools;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StatisticsChartDialog extends JDialog {
    public StatisticsChartDialog(String recordType) {
        this.addComponent(recordType);
        this.init();
    }

    private void init() {
        this.pack();
        GUITools.center(this);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public List<String> getImagePaths(String recordType){
        String imgpath = "chart/" + recordType + "Stock.png";
        List<String> imgList= new ArrayList<>();
        imgList.add(imgpath);
        return imgList;
    };

    /*
     * 调用子类重写方法getImagePaths,获取生成的图片的路径
     * 遍历集合List,获取所有的图片路径
     * 放到组件Label中
     */
    private void addComponent(String recordType) {
        List<String> imagePaths = getImagePaths(recordType);
        if(imagePaths == null) {
            return;
        }
        JPanel panel = new JPanel();
        this.add(panel);
        for(String imagePath : imagePaths) {
            try {
                Image image = ImageIO.read(new File(imagePath));
                panel.add(new JLabel(new ImageIcon(image)));
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
