package model;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JFrame;

public class OverlaidPlot extends JFrame
{


	final XYSeries series0 = new XYSeries("Framesize");
	final XYSeries series1 = new XYSeries("Max. Framesize");
	final XYSeries series2 = new XYSeries("Target Framesize ");
	final XYSeries series3 = new XYSeries("Average Framesize");

	public OverlaidPlot(String applicationTitle, String chartTitle) {
        super(applicationTitle);

        final JFreeChart chart = createOverlaidChart(chartTitle);
        final ChartPanel panel = new ChartPanel(chart, true, true, true, true, true);
        panel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(panel);
        this.setLocationRelativeTo(null);
        int x = this.getX() - 400;
        int y = this.getY() - 300;
        this.setLocation(x, y);
        
      }
        

   
   
   
public void addElem0(double x, double y)
{
    this.series0.add(x, y);
    
}

public void addElem1(double x, double y)
{
    this.series1.add(x, y);
}

public void addElem2(double x, double y)
{
    this.series2.add(x, y);
}

public void addElem3(double x, double y)
{
    this.series3.add(x, y);
}

private JFreeChart createOverlaidChart( String chartTitle) 
{
    final NumberAxis domainAxis = new NumberAxis("Frame Number");
    final ValueAxis rangeAxis = new NumberAxis("Framesize [Byte]");
    XYBarRenderer.setDefaultBarPainter(new StandardXYBarPainter());

    // create plot ...
    final IntervalXYDataset data0 = createDataset0();
    final XYBarRenderer renderer0 = new XYBarRenderer(0.2);
    renderer0.setShadowVisible(false);
    renderer0.setMargin(0);

    // change "new XYBarRenderer(0.20)" to "StandardXYItemRenderer()" if you want to change  type of graph
    final XYPlot plot = new XYPlot(data0, domainAxis, rangeAxis, renderer0);
    

    
    
    // add a second dataset and renderer... 
    final IntervalXYDataset data1 = createDataset1();
    final XYLineAndShapeRenderer renderer1 = new XYLineAndShapeRenderer(true, true); 
    // arguments of new XYLineAndShapeRenderer are to activate or deactivate the display of points or line. Set first argument to true if you want to draw lines between the points for e.g.
    renderer1.setSeriesShapesVisible(0, false);
    plot.setDataset(1, data1);
    plot.setRenderer(1, renderer1);

    // add a third dataset and renderer... 
    final IntervalXYDataset data2 = createDataset2();
    final XYLineAndShapeRenderer renderer2 = new XYLineAndShapeRenderer(true, true); 
    // arguments of new XYLineAndShapeRenderer are to activate or deactivate the display of points or line. Set first argument to true if you want to draw lines between the points for e.g.
    renderer2.setSeriesShapesVisible(0, false);
    plot.setDataset(2, data2);
    plot.setRenderer(2, renderer2);

    // add a third dataset and renderer... 
    final IntervalXYDataset data3 = createDataset3();
    final XYLineAndShapeRenderer renderer3 = new XYLineAndShapeRenderer(true, true); 
    // arguments of new XYLineAndShapeRenderer are to activate or deactivate the display of points or line. Set first argument to true if you want to draw lines between the points for e.g.
    renderer3.setSeriesShapesVisible(0, false);
    plot.setDataset(3, data3);
    plot.setRenderer(3, renderer3);
    
    
    plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
    NumberAxis domain = (NumberAxis) plot.getDomainAxis(); // X-Axis
    NumberAxis value = (NumberAxis) plot.getRangeAxis(); // Y-Axis
    
    value.setRange(1250000, 1600000);
    
    
    domain.setTickUnit(new NumberTickUnit(10));     
    domain.setVerticalTickLabels(true);
    // return a new chart containing the overlaid plot...
    return new JFreeChart(chartTitle, JFreeChart.DEFAULT_TITLE_FONT, plot, true);

}

private IntervalXYDataset createDataset0() 
{
    // create dataset 1...
    final XYSeriesCollection coll0 = new XYSeriesCollection(series0);
    return coll0;
}
	
private IntervalXYDataset createDataset1() 
{
    // create dataset 1...
    final XYSeriesCollection coll1 = new XYSeriesCollection(series1);
    return coll1;
}

private IntervalXYDataset createDataset2() 
{
    // create dataset 2...
    final XYSeriesCollection coll2 = new XYSeriesCollection(series2);
    return coll2;
}

private IntervalXYDataset createDataset3() 
{
    // create dataset 3...
    final XYSeriesCollection coll3 = new XYSeriesCollection(series3);
    return coll3;
}
}
