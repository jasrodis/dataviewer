package charts.dataviewer.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import charts.dataviewer.utils.AxisType;
/**
 * 
 * DataViewerConfiguration class is responsible for configuring the DataViewer.
 * 
 * @author irodis
 *
 */
@SuppressWarnings("unused")
public class DataViewerConfiguration {

	private final static transient Logger logger = LoggerFactory.getLogger(DataViewerConfiguration.class.getName());
	private final transient Gson gson = new Gson();

	private final String type = "CONFIG";

	private String plotTitle = "Plot Title";
	private String xAxisTitle = "Default X Title";
	private String yAxisTitle = "Default Y Title";

	private boolean showlegend = true;
	private int legendXaxis = 100;
	private int legendYaxis = 1;

	private int marginLeft = 60;
	private int marginRight = 30;
	private int marginTop = 90;
	private int marginBottom = 60;
	private int padding = 4;

	private double[] yRange = new double[] { 0.0, 0.0 };
	private double[] xRange = new double[] { 0.0, 0.0 };

	private double[] xRange2 = new double[] { 0.0, 0, 0 };
	private double[] yRange2 = new double[] { 0.0, 0, 0 };

	private AxisType xAxisType = AxisType.DEFAULT;
	private AxisType yAxisType = AxisType.DEFAULT;

	public DataViewerConfiguration() {}

	/**
	 * @return the plot title.
	 */
	public String getPlotTitle() {
		return plotTitle;
	}

	/**
	 * Set the plot title.
	 * @param plotTitle
	 */
	public void setPlotTitle(String plotTitle) {
		this.plotTitle = plotTitle;
	}

	/**
	 * @return the X axis title.
	 */
	public String getxAxisTitle() {
		return xAxisTitle;
	}

	/**
	 * Set the X axis title.
	 * @param xAxisTitle
	 */
	public void setxAxisTitle(String xAxisTitle) {
		this.xAxisTitle = xAxisTitle;
	}

	/**
	 * @return the Y axis title.
	 */
	public String getyAxisTitle() {
		return yAxisTitle;
	}

	/**
	 * Set the Y axis title.
	 * @param yAxisTitle
	 */
	public void setyAxisTitle(String yAxisTitle) {
		this.yAxisTitle = yAxisTitle;
	}

	/**
	 * @return object data serialized to Json.
	 */
	public String serialize() {
		return gson.toJson(this);
	}

	/**
	 * @return true or false, if legend is being showed.
	 */
	public boolean getShowLegend() {
		return showlegend;
	}

	/**
	 * Set if the plot legend is going to be shown.
	 * @param showlegend
	 */
	public void showLegend(boolean showlegend) {
		this.showlegend = showlegend;
	}

	/**
	 * @return left margin.
	 */
	public int getMarginLeft() {
		return marginLeft;
	}

	/**
	 * Set left margin.
	 * @param marginLeft
	 */
	public void setMarginLeft(int marginLeft) {
		this.marginLeft = marginLeft;
	}

	/**
	 * @return right margin.
	 */
	public int getMarginRight() {
		return marginRight;
	}

	/**
	 * Set right margin.
	 * @param marginRight
	 */
	public void setMarginRight(int marginRight) {
		this.marginRight = marginRight;
	}

	/**
	 * @return top margin.
	 */
	public int getMarginTop() {
		return marginTop;
	}

	/**
	 * Set top margin.
	 * @param marginTop
	 */
	public void setMarginTop(int marginTop) {
		this.marginTop = marginTop;
	}

	/**
	 * @return bottom margin.
	 */
	public int getMarginBottom() {
		return marginBottom;
	}

	/**
	 * Set bottom margin.
	 * @param marginBottom
	 */
	public void setMarginBottom(int marginBottom) {
		this.marginBottom = marginBottom;
	}

	/**
	 * @return padding.
	 */
	public int getPadding() {
		return padding;
	}

	/**
	 * Set padding.
	 * @param padding
	 */
	public void setPadding(int padding) {
		this.padding = padding;
	}

	/**
	 * @return the range of the Y axis.
	 */
	public double[] getyRange() {
		return yRange;
	}

	/**
	 * Set the range of the Y axis.
	 * 
	 * @param min
	 * @param max
	 */
	public void setyRange(double min, double max) {
		this.yRange[0] = min;
		this.yRange[1] = max;
	}

	/**
	 * @return the range of the X axis.
	 */
	public double[] getxRange() {
		return xRange;
	}

	/**
	 * Set the range of the X axis.
	 * @param min
	 * @param max
	 */
	public void setxRange(double min, double max) {
		this.xRange[0] = min;
		this.xRange[1] = max;
	}

	/**
	 * @return the secondary range of the Y axis.
	 */
	public double[] getyRange2() {
		return yRange2;
	}

	/**
	 * Set the range of the secondary Y axis.
	 * @param min
	 * @param max
	 */
	public void setyRange2(double min, double max) {
		this.yRange2[0] = min;
		this.yRange2[1] = max;
	}

	/**
	 * @return the secondary range of the X axis.
	 */
	public double[] getxRange2() {
		return xRange2;
	}

	/**
	 * Set the range of the secondary X axis.
	 * @param min
	 * @param max
	 */
	public void setxRange2(double min, double max) {
		this.xRange2[0] = min;
		this.xRange2[1] = max;
	}

	/**
	 * @return the type of the X axis.
	 */
	public AxisType getxAxisType() {
		return xAxisType;
	}

	/**
	 * Set the type of the X axis.
	 * @param xAxisType
	 */
	public void setxAxisType(AxisType xAxisType) {
		this.xAxisType = xAxisType;
	}

	/**
	 * @return the type of the Y axis.
	 */
	public AxisType getyAxisType() {
		return yAxisType;
	}

	/**
	 * Set the type of the Y axis.
	 * @param yAxisType
	 */
	public void setyAxisType(AxisType yAxisType) {
		this.yAxisType = yAxisType;
	}

	/**
	 * Set the legend to be visible inside the plot.
	 * @param inside
	 */
	public void setLegendInsidePlot(boolean inside) {
		if (inside) {
			showlegend = true;
			legendXaxis = 0;
			legendYaxis = 1;
		} else {
			legendXaxis = 100;
			legendYaxis = 1;
		}
	}

}
