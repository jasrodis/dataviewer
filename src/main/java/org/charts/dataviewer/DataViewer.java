package org.charts.dataviewer;

import org.charts.dataviewer.api.config.DataViewerConfiguration;
import org.charts.dataviewer.api.data.PlotData;
import org.charts.dataviewer.api.data.ResetData;
import org.charts.dataviewer.service.ChartServiceServer;
import org.charts.dataviewer.service.ChartsOpenedConnections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.scene.web.WebEngine;

/**
 * DataViewer class provides the creation of: 1) A Jetty WebServer (if not
 * created/running already). 2) A WebSocket Endpoint.
 * 
 * 
 * @author jasrodis
 *
 */
public class DataViewer {

	private static final Logger log = LoggerFactory.getLogger(DataViewer.class);

	// Unique chart id, should be improved
	private int uniqueChartID = (int) (System.currentTimeMillis() & 0xfffffff);

	private boolean enableFireBug = false;

	public DataViewer() {
		log.debug("DataViewer with id [{}] is being created! ", uniqueChartID);
		createWebsocketEndpoint();
		runServer();
	}

	private void runServer() {
		if (!ChartServiceServer.getInstance().getServer().isRunning()) {
			startingServerlog();
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

	private String getUrlToLoad() {
		return ChartServiceServer.getInstance().getDataViewerURL();
	}

	private void createWebsocketEndpoint() {
		ChartServiceServer.getInstance().addEndpoint(uniqueChartID);
	}

	/**
	 * Updates plot data.
	 * 
	 * @param PlotData
	 *            plotData
	 */
	public void updatePlot(PlotData plotData) {
		ChartsOpenedConnections.getInstance().sendMessage(uniqueChartID, plotData.serialize());
	}

	/**
	 * Removes all the traces from the DataViewer.
	 */
	public void resetPlot() {
		ChartsOpenedConnections.getInstance().sendMessage(uniqueChartID, new ResetData().serialize());
	}

	/**
	 * Update DataViewer Configuration.
	 * 
	 * @param DataViewerConfiguration
	 *            config
	 */
	public void updateConfiguration(DataViewerConfiguration config) {
		ChartsOpenedConnections.getInstance().sendMessage(uniqueChartID, config.serialize());
	}

	/**
	 * Enabling Firebug console to debug Javascirpt in the JavaFX webview.
	 * 
	 * @param engine
	 */
	private void enableFirebug(final WebEngine engine) {
		engine.executeScript(
				"if (!document.getElementById('FirebugLite')){E = document['createElement' + 'NS'] && document.documentElement.namespaceURI;E = E ? document['createElement' + 'NS'](E, 'script') : document['createElement']('script');E['setAttribute']('id', 'FirebugLite');E['setAttribute']('src', 'https://getfirebug.com/' + 'firebug-lite.js' + '#startOpened');E['setAttribute']('FirebugLite', '4');(document['getElementsByTagName']('head')[0] || document['getElementsByTagName']('body')[0]).appendChild(E);E = new Image;E['setAttribute']('src', 'https://getfirebug.com/' + '#startOpened');}");
	}

	private void startingServerlog() {
		log.debug("*--------------------------------------------*");
		log.debug("\tStarting Jetty Server..");
		log.debug("*--------------------------------------------*");
	}

	/**
	 * Get the Unique ID of the created Dataviewer.
	 */
	public int getUniqueID() {
		return uniqueChartID;
	}

	public String getUrl() {
		return ChartServiceServer.getInstance().getDataViewerURL() + uniqueChartID;
	}

}
