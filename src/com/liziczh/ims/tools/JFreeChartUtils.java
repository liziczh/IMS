package com.liziczh.ims.tools;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.io.File;
import java.util.Map;

public class JFreeChartUtils {
	/**
	 * 使用jfreechart生成图片
	 * @param title 标题
	 * @param totalMap 数据（key:分类名称, value：该分类的汇总数据，例如分类名称为"工资收入"，汇总数据为所有工资收入的和）
	 * @param sum 汇总数据和（例如"工资收入汇总 + 股票收入汇总 + ...."）
	 * @param path 生成图片保存路径
	 */
	public static void pie(String title, Map<String,Double> totalMap, double sum, String path) {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		for(String dataName : totalMap.keySet()) {
			double dataValue = totalMap.get(dataName);
			String bf = String.format("%.2f%%", dataValue / sum * 100);
			dataName = dataName + ":" + dataValue + "元(" + bf + ")";
			pieDataset.setValue(dataName, dataValue);
		}
		JFreeChart chart = ChartFactory.createPieChart3D(title, pieDataset, true, true, false);
		//JFreeChart chart=ChartFactory.createPieChart(title, pieDataset, true, true, false);
		//JFreeChart chart=ChartFactory.createRingChart(title, pieDataset, true, true, false);

		
		try {
			ChartUtilities.saveChartAsJPEG(new File(path), chart, 500, 300);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
