package org.charts.dataviewer.api.trace;

import org.charts.dataviewer.utils.TraceMode;
import org.charts.dataviewer.utils.TraceType;
import org.charts.dataviewer.utils.TraceVisibility;

public class LineTrace<T> extends GenericTrace<T> {

	public LineTrace() {
		setTraceName("Line Trace");
		setTraceType(TraceType.LINE);
		setTraceMode(TraceMode.LINES);
		setTraceVisibility(TraceVisibility.TRUE);
	}

	public LineTrace(String traceName) {
		setTraceName(traceName);
		setTraceType(TraceType.LINE);
		setTraceMode(TraceMode.LINES);
		setTraceVisibility(TraceVisibility.TRUE);
	}

	@Override
	public void setConfiguration(TraceConfiguration config) {
		this.traceConfig = config;
		this.traceConfig.setTraceType(TraceType.LINE);
	}

}
