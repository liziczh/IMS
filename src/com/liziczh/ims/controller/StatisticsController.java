package com.liziczh.ims.controller;

import com.liziczh.ims.service.ICountService;
import com.liziczh.ims.service.impl.CountServiceImpl;
import com.liziczh.ims.views.AbstractStatisticsPanel;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StatisticsController extends AbstractStatisticsPanel {

    ICountService countService = new CountServiceImpl();
    @Override
    public void setShape(){
        if(((String)dirBox.getSelectedItem()).equals("采购")){
            recordType = "in";
        }else if(((String)dirBox.getSelectedItem()).equals("销售")){
            recordType = "out";
        }
        countService.createPie(recordType,beginDateText.getText(),endDateText.getText());
        String imgpath = "chart/" + recordType + "Stock.png";
        List<String> imgList= new ArrayList<>();
        imgList.add(imgpath);
        List<String> imagePaths = imgList;
        if(imagePaths == null) {
            return;
        }
        for(String imagePath : imagePaths) {
            try {
                Image image = ImageIO.read(new File(imagePath));
                shapeLabel.setIcon(new ImageIcon(image));
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
