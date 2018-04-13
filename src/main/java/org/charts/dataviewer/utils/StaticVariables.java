package org.charts.dataviewer.utils;

/**
 * Static final Variables (configuration, icons, tooltip messages lie here)
 * 
 * @author jasrodis
 */
public class StaticVariables {

	private StaticVariables() {
		// Protect from instantiating
	}

	/********************************************************************************
	 * Config
	 ********************************************************************************/
	public static final int MIN_PORT = 8090;
	public static final int MAX_PORT = 8099;
	public static int PORT = 8090;

	public static final String DATAVIEWER_URL = "http://localhost:8090/view/";

	public static final String SERVLET_MAPPING = "/view/*";
	public static final String RESOURCE_BASE = "./src/main/resources/";
	public static final String WS_ENDPOINT = "/charts/";
	public static final String HTML_FILE = "/webapp/html/charts.html";

	public static final int WS_TIMEOUT = 10000000;

}
