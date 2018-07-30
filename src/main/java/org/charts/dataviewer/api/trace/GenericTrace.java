package org.charts.dataviewer.api.trace;

import org.charts.dataviewer.api.data.AbstractDataObject;
import org.charts.dataviewer.utils.TraceColour;
import org.charts.dataviewer.utils.TraceMode;
import org.charts.dataviewer.utils.TraceType;
import org.charts.dataviewer.utils.TraceVisibility;

public abstract class GenericTrace<T> extends AbstractDataObject<T> {

	protected TraceConfiguration traceConfig = new TraceConfiguration();

	// TODO: Temporary solution, needs fix.
	protected int uid = this.hashCode();
	// protected int uid = (int) (System.currentTimeMillis() & 0xfffffff);

	protected String xAxis = "";
	protected String yAxis = "";

	public abstract void setConfiguration(TraceConfiguration traceConfig);

	/**
	 * @return the trace name.
	 */
	public String getTraceName() {
		return traceConfig.traceName;
	}

	/**
	 * Sets the trace name.
	 * 
	 * @param traceName
	 */
	public void setTraceName(String traceName) {
		this.traceConfig.traceName = traceName;
	}

	/**
	 * @return the trace type
	 * @see TraceType
	 */
	public TraceType getTraceType() {
		return traceConfig.traceType;
	}

	/**
	 * Sets the trace type.
	 * 
	 * @param traceType
	 */
	public void setTraceType(TraceType traceType) {
		this.traceConfig.traceType = traceType;
	}

	/**
	 * @return the trace colour
	 * @see TraceColour
	 */
	public TraceColour getTraceColour() {
		return traceConfig.traceColour;
	}

	/**
	 * Sets the trace colour
	 * 
	 * @param traceColour
	 * @see TraceColour
	 */
	public void setTraceColour(TraceColour traceColour) {
		this.traceConfig.traceColour = traceColour;
	}

	/**
	 * @return the trace mode
	 * @see TraceMode
	 */
	public TraceMode getTraceMode() {
		return traceConfig.traceMode;
	}

	/**
	 * Sets the trace mode
	 * 
	 * @param traceMode
	 * @see TraceMode
	 */
	public void setTraceMode(TraceMode traceMode) {
		this.traceConfig.traceMode = traceMode;
	}

	public String getxAxis() {
		return xAxis;
	}

	public void setxAxis(String xAxis) {
		this.xAxis = xAxis;
	}

	public String getyAxis() {
		return yAxis;
	}

	public void setyAxis(String yAxis) {
		this.yAxis = yAxis;
	}

	/**
	 * Sets the trace visibility
	 * 
	 * @param traceVisibility
	 * @see TraceVisibility
	 */
	public void setTraceVisibility(TraceVisibility traceVisibility) {
		this.traceConfig.traceVisibility = traceVisibility;
	}

	/**
	 * @return the trace visibility (true, false, legendonly)
	 * @see TraceVisibility
	 */
	public TraceVisibility getTraceVisibility() {
		return traceConfig.traceVisibility;
	}

	public String serialize() {
		return gson.toJson(this);
	}

}
