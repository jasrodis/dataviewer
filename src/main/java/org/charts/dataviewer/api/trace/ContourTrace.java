package org.charts.dataviewer.api.trace;

import org.charts.dataviewer.utils.TraceColour;
import org.charts.dataviewer.utils.TraceType;
import org.charts.dataviewer.utils.TraceVisibility;

public class ContourTrace<T extends Number> extends GenericTrace<T> {

	public ContourTrace() {
		setTraceName("Contoure Trace");
		setTraceType(TraceType.CONTOUR);
		setTraceColour(TraceColour.ORANGE);
		setTraceVisibility(TraceVisibility.TRUE);
	}

	public ContourTrace(String traceName) {
		setTraceName(traceName);
		setTraceType(TraceType.CONTOUR);
		setTraceColour(TraceColour.ORANGE);
		setTraceVisibility(TraceVisibility.TRUE);
	}

	@Override
	public void setConfiguration(TraceConfiguration config) {
		this.traceConfig = config;
		this.traceConfig.setTraceType(TraceType.CONTOUR);
	}

}
