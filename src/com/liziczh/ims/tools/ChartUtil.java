package com.liziczh.ims.tools;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYBoxAnnotation;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.TextAnchor;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

/*
各种数据集格式说明：
3D饼图：
String[] keys = { "王晓博", "李冰", "牛根生", "李开复", "马云", "其它" };
 double[] data = { 60, 60, 55, 77, 80, 50 };
 DefaultPieDataset dataset = new DefaultPieDataset();
 for (int i = 0; i < keys.length; i++) {
  dataset.setValue(keys[i], data[i]);
 }



折线图：
DefaultCategoryDataset ds = new DefaultCategoryDataset();
ds.addValue(90, "温度", "2011-01-01");
ds.addValue(100, "温度", "2011-01-02");
ds.addValue(80, "温度", "2011-01-03");
ds.addValue(120, "温度", "2011-01-04");
ds.addValue(130, "湿度", "2011-01-01");
ds.addValue(100, "湿度", "2011-01-02");
ds.addValue(150, "湿度", "2011-01-03");
ds.addValue(140, "湿度", "2011-01-04");
柱状图：
DefaultCategoryDataset dataset = new DefaultCategoryDataset();
dataset.addValue(100, "struts1.2", "张三");
dataset.addValue(200, "struts2.x", "张三");
dataset.addValue(300, "webwork", "张三");
dataset.addValue(400, "spring", "张三");
dataset.addValue(100, "struts1.2", "李四");
dataset.addValue(200, "struts2.x", "李四");
dataset.addValue(300, "webwork", "李四");
dataset.addValue(400, "spring", "李四");  //dataset.addValue(-20,　"Ext　JS",　"Jan")负向坐标
散点图：
double[][] data1 = new double[2][5];
DefaultXYDataset xydataset = new DefaultXYDataset();
data1[0][0] = 80;
data1[1][0] = 88;
data1[0][1] = 82;
data1[1][1] = 90;
data1[0][2] = 98;
data1[1][2] = 67;
data1[0][3] = 110;
data1[1][3] = 120;
data1[0][4] = 122;
data1[1][4] = 132;
xydataset.addSeries("温度", data1);



条形图：
double[][] data = new double[][] { { 1310, 1220, 1110, 1000, 666 },
{ 720, 700, 680, 640, 777 }, { 1130, 1020, 980, 800, 888 },
{ 440, 400, 360, 300, 999 }, { 400, 400, 400, 400, 555 } };
String[] rowKeys = { "猪肉", "牛肉", "鸡肉", "鱼肉", "羊肉" };
String[] columnKeys = { "襄城", "樊城", "襄州", "东津", "鱼梁州" };
CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
rowKeys, columnKeys, data);
 */
public class ChartUtil {

    public static String createPieChart3D(String title,  PieDataset dataset,
                                          String path,String imgName) {
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true,
                true, Locale.CHINA);

// 使下面的说明标签字体清晰,类似于去锯齿的效果
        chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        chart.setTextAntiAlias(false);
// 图片背景色
        chart.setBackgroundPaint(Color.white);

// 设置图标题的字体重新设置title(否组有些版本Title会出现乱码)
        chart.getTitle().setFont((new Font("隶书", Font.CENTER_BASELINE, 20)));

// 设置图例(Legend)上的文字(//底部的字体)
        chart.getLegend().setItemFont(new Font("隶书", Font.CENTER_BASELINE, 15));

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
// 图片中显示百分比:默认方式

// 指定饼图轮廓线的颜色
        plot.setBaseSectionOutlinePaint(Color.BLACK);
        plot.setBaseSectionPaint(Color.BLACK);

// 设置无数据时的信息
        plot.setNoDataMessage("无对应的数据，请重新查询。");

// 设置无数据时的信息显示颜色
        plot.setNoDataMessagePaint(Color.red);

// 图片中显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
                "{0}={1}({2})", NumberFormat.getNumberInstance(),
                new DecimalFormat("0.00%")));
// 图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例
        plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator(
                "{0}({2})"));

        plot.setLabelFont(new Font("华文楷体", Font.TRUETYPE_FONT, 12));

// 指定图片的透明度(0.0-1.0)
        plot.setForegroundAlpha(0.65f);
// 指定显示的饼图上圆形(false)还椭圆形(true)
        plot.setCircular(false, true);

// 设置第一个 饼块section 的开始位置，默认是12点钟方向
        plot.setStartAngle(90);

// 设置分饼颜色(不设置它会自己设置)
// plot.setSectionPaint(pieKeys[0], new Color(244, 194, 144));
// plot.setSectionPaint(pieKeys[1], new Color(144, 233, 144));

// 把饼图生成图片
        String chartName = "";
        FileOutputStream fos_jpg = null;
        try {
// 文件夹不存在则创建
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            chartName = path + File.separator + imgName+ ".png";
            fos_jpg = new FileOutputStream(chartName);
// 高宽的设置影响椭圆饼图的形状
            ChartUtilities.writeChartAsPNG(fos_jpg, chart, 500, 300);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos_jpg.close();// http://1wangxiaobo@163.com
            } catch (Exception e) {
                e.printStackTrace();
            }
            return chartName;
        }
    }

    public static String createLineChart(String title, String domainAxisName,
                                         String rangeAxisName, DefaultCategoryDataset ds, String path) {
        JFreeChart chart = ChartFactory.createLineChart3D(title, domainAxisName,
                rangeAxisName, ds, PlotOrientation.VERTICAL, // 绘制方向
                true, // 显示图例
                true, // 采用标准生成器
                false // 是否生成超链接
        );
        chart.getTitle().setFont((new Font("隶书", Font.CENTER_BASELINE, 20))); // 设置标题字体
        chart.getLegend().setItemFont(new Font("隶书", Font.CENTER_BASELINE, 15));// 设置图例类别字体
// 获取绘图区对象
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.LIGHT_GRAY); // 设置绘图区背景色
        plot.setRangeGridlinePaint(Color.WHITE); // 设置水平方向背景线颜色
        plot.setRangeGridlinesVisible(true);// 设置是否显示水平方向背景线,默认值为true
        plot.setDomainGridlinePaint(Color.WHITE); // 设置垂直方向背景线颜色
        plot.setDomainGridlinesVisible(true); // 设置是否显示垂直方向背景线,默认值为false

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setLabelFont(new Font("隶书", Font.CENTER_BASELINE, 15)); // 设置横轴字体
// domainAxis.setTickLabelFont(font);// 设置坐标轴标尺值字体
        domainAxis.setLowerMargin(0.01);// 左边距 边框距离
        domainAxis.setUpperMargin(0.06);// 右边距 边框距离,防止最后边的一个数据靠近了坐标轴。
        domainAxis.setMaximumCategoryLabelLines(2);

        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("隶书", Font.CENTER_BASELINE, 15));
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());// Y轴显示整数
        rangeAxis.setAutoRangeMinimumSize(1); // 最小跨度
        rangeAxis.setUpperMargin(0.18);// 上边距,防止最大的一个数据靠近了坐标轴。
        rangeAxis.setLowerBound(0); // 最小值显示0
        rangeAxis.setAutoRange(false); // 不自动分配Y轴数据
        rangeAxis.setTickMarkStroke(new BasicStroke(1.6f)); // 设置坐标标记大小
        rangeAxis.setTickMarkPaint(Color.BLACK); // 设置坐标标记颜色

// 获取折线对象
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot
                .getRenderer();
        BasicStroke realLine = new BasicStroke(1.8f); // 设置实线
// 设置虚线
        float dashes[] = { 5.0f };
        BasicStroke brokenLine = new BasicStroke(2.2f, // 线条粗细
                BasicStroke.CAP_ROUND, // 端点风格
                BasicStroke.JOIN_ROUND, // 折点风格
                8f, dashes, 0.6f);

        plot.setNoDataMessage("无对应的数据，请重新查询。");
        plot.setNoDataMessagePaint(Color.RED);// 字体颜色
// 把饼图生成图片
        String chartName = "";
        FileOutputStream fos_jpg = null;
        try {
// 文件夹不存在则创建
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            chartName = path + File.separator + new Date().getTime() + ".png";
            fos_jpg = new FileOutputStream(chartName);
// 高宽的设置影响椭圆饼图的形状
            ChartUtilities.writeChartAsPNG(fos_jpg, chart, 700, 400);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos_jpg.close();// http://1wangxiaobo@163.com
            } catch (Exception e) {
                e.printStackTrace();
            }
            return chartName;
        }
    }

    public static String createCategoryDataset(String title, String domainName,
                                               String rangeName, DefaultCategoryDataset dataset, String path) {
        JFreeChart chart = ChartFactory
                .createBarChart(title, domainName, rangeName, dataset,
                        PlotOrientation.VERTICAL, true, true, false);
        chart.getTitle().setFont((new Font("隶书", Font.CENTER_BASELINE, 20))); // 设置标题字体
        CategoryPlot plot = chart.getCategoryPlot();// 获得图表区域对象
// 设置图表的纵轴和横轴org.jfree.chart.axis.CategoryAxis
        CategoryAxis domainAxis = plot.getDomainAxis();
        NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();
        TextTitle textTitle = chart.getTitle();
        textTitle.setFont(new Font("黑体", Font.PLAIN, 20));
        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
        numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
        numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));

        String chartName = "";
        FileOutputStream fos_jpg = null;
        try {
// 文件夹不存在则创建
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            chartName = path + File.separator + new Date().getTime() + ".png";
            fos_jpg = new FileOutputStream(chartName);
// 高宽的设置影响椭圆饼图的形状
            ChartUtilities.writeChartAsPNG(fos_jpg, chart, 700, 400);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos_jpg.close();// http://1wangxiaobo@163.com
            } catch (Exception e) {
                e.printStackTrace();
            }
            return chartName;
        }
    }

    public static String createBarChart(String title, String domainName,
                                        String rangeName, CategoryDataset dataset, String path) {
        JFreeChart chart = ChartFactory.createBarChart3D(title,domainName ,
                rangeName, dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = chart.getCategoryPlot();
        chart.getTitle().setFont((new Font("隶书", Font.CENTER_BASELINE, 20))); // 设置标题字体
// 设置网格背景颜色
        plot.setBackgroundPaint(Color.white);
// 设置网络竖线颜色
        plot.setDomainGridlinePaint(Color.pink);
// 显示每个柱的数值，并修改该数字的字体属性
        BarRenderer3D renderer = new BarRenderer3D();
        renderer
                .setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
// 默认的数字显示在柱子中，通过以下两句调整数字的显示
// 注意，此句很关键，若无此句，那数字的显示会覆盖，给人数字没有显示出来的问题
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
                ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
        renderer.setItemLabelAnchorOffset(10D);
// 设置每个地区所包含的平行柱的之间的距离
// renderer.setItemMargin(0.3);
        plot.setRenderer(renderer);

// 设置位置
        plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
// 将默认的左边的放到右方
        plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();
        CategoryAxis domainAxis = plot.getDomainAxis();
// 图表标题
        Font font = new Font("宋体", Font.BOLD, 16);
        chart.setTitle(title); // 标题

// X轴乱码
// X轴坐标上的文字：
        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
// X轴坐标标题
        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
// Y轴坐标上的文字
        numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
// Y轴坐标标题
        numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));
// 图表底部乱码
        chart.getLegend().setItemFont(new Font("黑体", Font.PLAIN, 12));
        String chartName = "";
        FileOutputStream fos_jpg = null;
        try {
// 文件夹不存在则创建
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            chartName = path + File.separator + new Date().getTime() + ".png";
            fos_jpg = new FileOutputStream(chartName);
// 高宽的设置影响椭圆饼图的形状
            ChartUtilities.writeChartAsPNG(fos_jpg, chart, 700, 400);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos_jpg.close();// http://1wangxiaobo@163.com
            } catch (Exception e) {
                e.printStackTrace();
            }
            return chartName;
        }
    }
    public static String createPointChart(XYDataset xydataset, String title, String domainName, String rangeName, String noDateMsg, String path){

        JFreeChart jfreechart = ChartFactory.createScatterPlot(title,
                domainName, rangeName, xydataset, PlotOrientation.VERTICAL, true, false,
                false);
        jfreechart.setBackgroundPaint(Color.white);
        jfreechart.setBorderPaint(Color.GREEN);
        jfreechart.setBorderStroke(new BasicStroke(1.5f));
        jfreechart.getTitle().setFont((new Font("隶书", Font.CENTER_BASELINE, 20)));
        jfreechart.getLegend().setItemFont(new Font("隶书", Font.CENTER_BASELINE, 15));// 设置图例类别字体

        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        xyplot.setNoDataMessage(noDateMsg);
        xyplot.setNoDataMessageFont(new Font("隶书", Font.BOLD, 14));
        //xyplot.setNoDataMessagePaint(new Color(87, 149, 117));

        xyplot.setBackgroundPaint(new Color(255, 253, 246));
        ValueAxis vaaxis = xyplot.getDomainAxis();
        vaaxis.setAxisLineStroke(new BasicStroke(1.5f));

        ValueAxis va = xyplot.getDomainAxis(0);
        va.setAxisLineStroke(new BasicStroke(1.5f));

        va.setAxisLineStroke(new BasicStroke(1.5f)); // 坐标轴粗细
        va.setAxisLinePaint(new Color(215, 215, 215)); // 坐标轴颜色
        xyplot.setOutlineStroke(new BasicStroke(1.5f)); // 边框粗细
        va.setLabelPaint(new Color(10, 10, 10)); // 坐标轴标题颜色
        va.setTickLabelPaint(new Color(102, 102, 102)); // 坐标轴标尺值颜色
        ValueAxis axis = xyplot.getRangeAxis();
        vaaxis.setLabelFont(new Font("隶书", Font.CENTER_BASELINE, 15));
        axis.setAxisLineStroke(new BasicStroke(1.5f));

        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyplot
                .getRenderer();
        xylineandshaperenderer.setSeriesOutlinePaint(0, Color.WHITE);
        xylineandshaperenderer.setUseOutlinePaint(true);
        NumberAxis numberaxis = (NumberAxis) xyplot.getDomainAxis();
        numberaxis.setAutoRangeIncludesZero(false);
        numberaxis.setTickMarkInsideLength(2.0F);
        numberaxis.setTickMarkOutsideLength(0.0F);
        numberaxis.setAxisLineStroke(new BasicStroke(1.5f));
        // numberaxis.setUpperBound(maxpress); 最大值设置
        // numberaxis.setLowerBound();最小值设置
        NumberAxis numberaxis1 = (NumberAxis) xyplot.getRangeAxis();
        numberaxis1.setTickMarkInsideLength(2.0F);
        numberaxis1.setTickMarkOutsideLength(0.0F);
        numberaxis1.setUpperBound(150d);
        numberaxis1.setLowerBound(35);
        numberaxis1.setAxisLineStroke(new BasicStroke(1.5f));
        numberaxis1.setLabelFont(new Font("隶书", Font.CENTER_BASELINE, 15));

        XYBoxAnnotation box = new XYBoxAnnotation(0, 0, 89, 59); //正常血压所在区域内边界
        XYBoxAnnotation box1 = new XYBoxAnnotation(0, 0, 119, 79);//高血压前期所在区域内边界
        XYBoxAnnotation box2 = new XYBoxAnnotation(0, 0, 139, 89);//高血压一期所在区域内边界
        XYBoxAnnotation box3 = new XYBoxAnnotation(0, 0, 159, 99);//高血压二期所在区域内边界
        XYTextAnnotation text1 = new XYTextAnnotation("nomal", 70, 62.5);//标识“正常”
        XYTextAnnotation text = new XYTextAnnotation("fore", 70, 82.5);//“高血压前期”
        XYTextAnnotation text2 = new XYTextAnnotation("one", 70, 91.5);//“高血压一期”
        XYTextAnnotation text3 = new XYTextAnnotation("two", 70, 101.5);//“高血压二期”


        //将上面的边界线条，说明文字加入到xyplot中。
        xyplot.addAnnotation(box);
        xyplot.addAnnotation(box1);
        xyplot.addAnnotation(box2);
        xyplot.addAnnotation(box3);

        xyplot.addAnnotation(text);
        xyplot.addAnnotation(text1);
        xyplot.addAnnotation(text2);
        xyplot.addAnnotation(text3);
        String chartName = "";
        FileOutputStream fos_jpg = null;
        try {
// 文件夹不存在则创建
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            chartName = path + File.separator + new Date().getTime() + ".png";
            fos_jpg = new FileOutputStream(chartName);
            ChartUtilities.writeChartAsPNG(fos_jpg, jfreechart, 700, 400);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos_jpg.close();// http://1wangxiaobo@163.com
            } catch (Exception e) {
                e.printStackTrace();
            }
            return chartName;
        }
    }
}