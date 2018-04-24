package org.charts.dataviewer.service;

import org.charts.dataviewer.utils.StaticVariables;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChartServiceSocketServlet extends WebSocketServlet {

	private static final long serialVersionUID = -624546172506336056L;

	private static final Logger log = LoggerFactory.getLogger(ChartServiceSocketServlet.class);

	private final String chartId;

	public ChartServiceSocketServlet(String uuid) {
		log.trace("ChartserviceSocketServlet constructor called ! ");
		this.chartId = uuid;
	}

	@Override
	public void configure(WebSocketServletFactory factory) {
		log.trace("CALL TO CONFIGURE__ {} ", chartId);
		factory.getPolicy().setIdleTimeout(StaticVariables.WS_TIMEOUT);
		factory.setCreator(new AdvancedWebSocketCreator(chartId));
	}

}