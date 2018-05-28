package com.liziczh.ims.service.impl;

import com.liziczh.ims.dao.ILedgerDao;
import com.liziczh.ims.dao.impl.LedgerDaoImpl;
import com.liziczh.ims.service.ILedgerService;
import com.liziczh.ims.tools.ChartUtil;
import org.jfree.data.general.DefaultPieDataset;
import java.util.ArrayList;
import java.util.List;

public class LedgerServiceImpl implements ILedgerService {

    @Override
    public List<String> createPie(String recordType, String startTime, String endTime) {
        ILedgerDao dao = new LedgerDaoImpl();
        List<String> imgList = new ArrayList<>();
        String title;
        if(recordType == "in"){
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
    }
}
