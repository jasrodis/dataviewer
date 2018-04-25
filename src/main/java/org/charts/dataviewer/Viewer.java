package org.charts.dataviewer;

import org.charts.dataviewer.api.config.DataViewerConfiguration;
import org.charts.dataviewer.api.data.PlotData;

/**
 * Viewer interface is the API of the DataViewer.
 *
 * The user can update the plotData and configuration and can retrieve the URL
 * of the chart or the UniqueId
 * 
 * @author jasrodis
 */
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
	 * @param plotData
	 *            the PlotData
	 * 
	 */
	void updatePlot(PlotData plotData);

	/**
	 * Removes all the traces from the DataViewer.
	 */
	void resetPlot();

	/**
	 * Get the Unique ID of the created DataViewer.
	 */
	String getUniqueID();

	/**
	 * Get the URL of the DataViewer.
	 */
	String getUrl();

}
