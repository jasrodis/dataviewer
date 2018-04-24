package org.charts.dataviewer.service;

import java.net.MalformedURLException;
import java.net.URL;

import org.charts.dataviewer.exception.PortNotAvailiableExcpetion;
import org.charts.dataviewer.utils.DataViewerUtils;
import org.charts.dataviewer.utils.StaticVariables;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChartServiceServer implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(ChartServiceServer.class);

	public static final ChartServiceServer INSTANCE = new ChartServiceServer();

	public static ChartServiceServer getInstance() {
		return INSTANCE;
	}

	private Server server;
	private URL dataviewerURL;

	// Servlets
	private ServletContextHandler ctx;

	protected ChartServiceServer() {
		buildURL();
		server = new Server(StaticVariables.PORT);
		configureServer();
	}

	private void configureServer() {
		ctx = new ServletContextHandler();
		ctx.setContextPath("/");

		HtmlServlet htmlServlet = new HtmlServlet();
		ctx.addServlet(new ServletHolder(htmlServlet), StaticVariables.SERVLET_MAPPING);

		URL url = ChartServiceServer.class.getProtectionDomain().getCodeSource().getLocation();
		try {
			url = new URL("jar:" + url.toExternalForm() + "!/webapp");
		} catch (MalformedURLException e) {
			log.warn("Malformed URL", e);
		}

		// Set static handler
		CustomResourceHandler customResourceHandler = new CustomResourceHandler();
		customResourceHandler.setDirectoriesListed(true);
		customResourceHandler.setResourceBase(url);

		// Set Handlers
		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] { customResourceHandler, ctx });
		server.setHandler(handlers);
	}

	public void addEndpoint(String udID) {
		String endpoint = StaticVariables.WS_ENDPOINT + udID;
		log.debug("Endpoint [{}] created for : {}", endpoint, udID);

		ServletHolder holder = new ServletHolder();
		ChartServiceSocketServlet chartServiceSocketServlet = new ChartServiceSocketServlet(udID);
		holder.setServlet(chartServiceSocketServlet);
		ctx.addServlet(holder, endpoint);
	}

	private void buildURL() {
		int port = StaticVariables.PORT;
		while (!DataViewerUtils.available(port) && port < StaticVariables.MAX_PORT) {
			port++;
		}
		if (!DataViewerUtils.available(port) && port >= StaticVariables.MAX_PORT) {
			throw new PortNotAvailiableExcpetion("Could not find port availiable.");
		}
		try {
			dataviewerURL = new URL("http", "localhost", port, "/view/");
		} catch (MalformedURLException ex) {
			log.error("Malformed URL : ", ex);
		}
		StaticVariables.PORT = port;
	}

	public String getDataViewerURL() {
		return dataviewerURL.toExternalForm();
	}

	@Override
	public void run() {
		try {
			server.start();
		} catch (Exception e) {
			log.error("Error starting server", e);
		}
	}

	public Server getServer() {
		return server;
	}

}
