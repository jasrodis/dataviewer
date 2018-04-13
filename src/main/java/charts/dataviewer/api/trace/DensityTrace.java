package charts.dataviewer.api.trace;

import charts.dataviewer.utils.TraceColour;
import charts.dataviewer.utils.TraceMode;
import charts.dataviewer.utils.TraceType;
import charts.dataviewer.utils.TraceVisibility;

public class DensityTrace<T extends Number> extends GenericTrace<T> {
	
	public DensityTrace(Histogram2dContourTrace<T> h2dc, HistogramTrace<T> xh, HistogramTrace<T> yx) {
		setTraceName("Density Trace");
		setTraceColour(TraceColour.ORANGE);
		setTraceMode(TraceMode.LINES);
		setTraceVisibility(TraceVisibility.TRUE);
	}

	public DensityTrace(String traceName) {
		setTraceName(traceName);
		setTraceType(TraceType.LINE);
		setTraceColour(TraceColour.ORANGE);
		setTraceMode(TraceMode.LINES);
		setTraceVisibility(TraceVisibility.TRUE);
	}

	@Override
	public void setConfiguration(TraceConfiguration config) {
		this.traceConfig = config;
		this.traceConfig.setTraceType(TraceType.LINE);
	}

}
