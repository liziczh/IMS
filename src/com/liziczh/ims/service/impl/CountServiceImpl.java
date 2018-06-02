package com.liziczh.ims.service.impl;

import com.liziczh.ims.dao.IRecordDao;
import com.liziczh.ims.dao.impl.RecordDaoImpl;
import com.liziczh.ims.service.ICountService;
import com.liziczh.ims.tools.ChartUtil;
import org.jfree.data.general.DefaultPieDataset;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountServiceImpl implements ICountService {

    @Override
    public List<String> createPie(String recordType, String startTime, String endTime) {
        IRecordDao dao = new RecordDaoImpl();
        List<String> imgList = new ArrayList<>();
        String title;
        try {
        if("in".equals(recordType)){
            title = "入库商品各分类占比统计图（"+ dao.getTotalCount(recordType)+")"+ startTime + "至" + endTime;
        }else{
            title = "出库商品各分类占比统计图（"+ dao.getTotalCount(recordType)+")"+ startTime + "至" + endTime;
        }
        List<Object[]> list = dao.getSumCountByDirName(recordType,startTime,endTime);
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Object[] obj : list){
            int count = Integer.parseInt(obj[0].toString());
            String dirName = (String)obj[1];
            dataset.setValue(dirName,count);
        }
        ChartUtil.createPieChart3D(title,dataset,"chart",recordType +"Stock");
        imgList.add("chart/"+ recordType +"Stock.png");
        return imgList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
