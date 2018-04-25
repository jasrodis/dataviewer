package org.charts.dataviewer;

import org.charts.dataviewer.api.config.DataViewerConfiguration;
import org.charts.dataviewer.api.data.PlotData;

public interface Viewer {

	/**
	 * Update DataViewer Configuration.
	 * 
	 * @param config
	 *            DataViewerConfiguration
	 */
	void updateConfiguration(DataViewerConfiguration config);

	/**
	 * Updates plot data.
	 * 
	 * @param PlotData
	 *            plotData
	 */
	void updatePlot(PlotData plotData);

	/**
	 * Removes all the traces from the DataViewer.
	 */
	void resetPlot();

}
