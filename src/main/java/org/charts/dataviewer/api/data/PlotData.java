package org.charts.dataviewer.api.data;

import java.util.ArrayList;
import java.util.List;

import org.charts.dataviewer.api.trace.GenericTrace;

import com.google.gson.Gson;

/**
 * A Container of all the Traces to be plotted.
 * 
 * @author irodis
 */
public class PlotData {

	protected final String type = "PAYLOAD";

	private final transient Gson gson = new Gson();
	private List<GenericTrace<?>> traces = new ArrayList<>();

	public PlotData() {
	}

	public PlotData(GenericTrace<?>... traces) {
		addAll(traces);
	}

	public List<GenericTrace<?>> getAllTraces() {
		return traces;
	}

	public void addTrace(GenericTrace<?> trace) {
		traces.add(trace);
	}

	public void addAll(GenericTrace<?>... traces) {
		for (GenericTrace<?> trace : traces) {
			this.traces.add(trace);
		}
	}

	public String serialize() {
		return gson.toJson(this);
	}

}
