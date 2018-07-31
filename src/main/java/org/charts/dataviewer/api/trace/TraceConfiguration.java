package org.charts.dataviewer.api.trace;

import org.charts.dataviewer.utils.TraceColour;
import org.charts.dataviewer.utils.TraceMode;
import org.charts.dataviewer.utils.TraceType;
import org.charts.dataviewer.utils.TraceVisibility;

/**
 * TraceConfiguration class specifies trace characteristics, such as trace name,
 * colour etc.
 * 
 * @author jasrodis
 */
public class TraceConfiguration {

	protected String traceName;
	protected TraceType traceType;
	protected TraceColour traceColour;
	protected TraceMode traceMode;
	protected TraceVisibility traceVisibility;

	/**
	 * @return the trace name.
	 */
	public String getTraceName() {
		return traceName;
	}

	/**
	 * Sets the trace name.
	 * 
	 * @param traceName
	 */
	public void setTraceName(String traceName) {
		this.traceName = traceName;
	}

	/**
	 * @return the trace type
	 * @see TraceType
	 */
	public TraceType getTraceType() {
		return traceType;
	}

	/**
	 * Sets the trace type.
	 * 
	 * @param traceType
	 */
	protected void setTraceType(TraceType traceType) {
		this.traceType = traceType;
	}

	/**
	 * @return the trace colour
	 * @see TraceColour
	 */
	public TraceColour getTraceColour() {
		return traceColour;
	}

	/**
	 * Sets the trace colour
	 * 
	 * @param traceColour
	 * @see TraceColour
	 */
	public void setTraceColour(TraceColour traceColour) {
		this.traceColour = traceColour;
	}

	/**
	 * @return the trace mode
	 * @see the TraceMode
	 */
	public TraceMode getTraceMode() {
		return traceMode;
	}

	/**
	 * Sets the trace mode
	 * 
	 * @param traceMode
	 * @see TraceMode
	 */
	public void setTraceMode(TraceMode traceMode) {
		this.traceMode = traceMode;
	}

	/**
	 * @return the trace visibility (true, false, legendonly)
	 * @see the TraceVisibility
	 */
	public TraceVisibility getTraceVisibility() {
		return traceVisibility;
	}

	/**
	 * Sets the trace visibility
	 * 
	 * @param traceVisibility
	 * @see TraceVisibility
	 */
	public void setTraceVisibility(TraceVisibility traceVisibility) {
		this.traceVisibility = traceVisibility;
	}

}
