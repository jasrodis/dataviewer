package charts.dataviewer.topmenu;

import javafx.beans.property.SimpleObjectProperty;

public class PlotDataTableModel {

	private final SimpleObjectProperty<Object> xdata;
	private final SimpleObjectProperty<Object> ydata;
	private final SimpleObjectProperty<Object> zdata;

	public PlotDataTableModel(Object xData, Object yData, Object zData) {
		this.xdata = new SimpleObjectProperty<Object>();
		this.ydata = new SimpleObjectProperty<Object>();
		this.zdata = new SimpleObjectProperty<Object>();
		setXdata(xData);
		setYdata(yData);
		setZdata(zData);
	}

	public Object getXdata() {
		return xdata.get();
	}

	public void setXdata(Object xData) {
		this.xdata.set(xData);
	}

	public Object getYdata() {
		return ydata.get();
	}

	public void setYdata(Object yData) {
		this.ydata.set(yData);
	}

	public Object getZdata() {
		return zdata.get();
	}

	public void setZdata(Object zData) {
		this.zdata.set(zData);
	}

}
