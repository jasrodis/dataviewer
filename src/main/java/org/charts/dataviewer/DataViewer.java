package org.charts.dataviewer;

import org.charts.dataviewer.api.config.DataViewerConfiguration;
import org.charts.dataviewer.api.data.PlotData;
import org.charts.dataviewer.api.data.ResetData;
import org.charts.dataviewer.service.ChartServiceServer;
import org.charts.dataviewer.service.ChartsOpenedConnections;
import org.charts.dataviewer.utils.StaticVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DataViewer class provides the creation of: 1) A Jetty WebServer (if not
 * created/running already). 2) A WebSocket Endpoint.
 * 
 * @author jasrodis
 */
public class DataViewer implements Viewer {

	private static final Logger log = LoggerFactory.getLogger(DataViewer.class);

	// Unique chart id, should be improved
	protected String uniqueChartId = String.valueOf((int) (System.currentTimeMillis() & 0xfffffff));

	public DataViewer() {
		createWebsocketEndpoint();
		runServer();
		log.info("DataViewer created @ {}", getUrl());
	}

	public DataViewer(String chartId) {
		this.uniqueChartId = chartId;
		createWebsocketEndpoint();
		runServer();
		log.info("DataViewer created @ {}", getUrl());
	}

	protected void createWebsocketEndpoint() {
		ChartServiceServer.getInstance().addEndpoint(uniqueChartId);
	}

	protected void runServer() {
		if (!ChartServiceServer.getInstance().getServer().isRunning()) {
			StaticVariables.startingServerLog();
			Thread serverThread = new Thread(ChartServiceServer.getInstance());
			serverThread.start();
			try {
				serverThread.join();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				log.error("Error in runServer()", e);
			}
		}
	}

	@Override
	public void updatePlot(PlotData plotData) {
		ChartsOpenedConnections.getInstance().sendMessage(uniqueChartId, plotData.serialize());
	}

	@Override
	public void resetPlot() {
		ChartsOpenedConnections.getInstance().sendMessage(uniqueChartId, new ResetData().serialize());
	}

	@Override
	public void updateConfiguration(DataViewerConfiguration config) {
		ChartsOpenedConnections.getInstance().sendMessage(uniqueChartId, config.serialize());
	}

	@Override
	public String getUniqueID() {
		return uniqueChartId;
	}

	@Override
	public String getUrl() {
		return ChartServiceServer.getInstance().getDataViewerURL() + uniqueChartId;
	}

}
