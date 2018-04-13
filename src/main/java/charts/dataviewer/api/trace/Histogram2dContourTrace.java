package charts.dataviewer.api.trace;

import charts.dataviewer.utils.TraceType;
import charts.dataviewer.utils.TraceVisibility;

public class Histogram2dContourTrace<T> extends GenericTrace<T> {

	public Histogram2dContourTrace() {
		setTraceName("Histogram2dContour Trace");
		setTraceType(TraceType.HISTOGRAM_2D_CONTOUR);
		setTraceVisibility(TraceVisibility.TRUE);
	}

	public Histogram2dContourTrace(String traceName) {
		setTraceName(traceName);
		setTraceType(TraceType.HISTOGRAM_2D_CONTOUR);
		setTraceVisibility(TraceVisibility.TRUE);
	}

	@Override
	public void setConfiguration(TraceConfiguration config) {
		this.traceConfig = config;
		this.traceConfig.setTraceType(TraceType.HISTOGRAM_2D_CONTOUR);
	}

}
