package org.charts.dataviewer.service;

import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdvancedWebSocketCreator implements WebSocketCreator {

	private static final Logger log = LoggerFactory.getLogger(AdvancedWebSocketCreator.class);

	private ChartServiceWebSocket chartServiceWebSocket;

	public AdvancedWebSocketCreator(String uuid) {
		log.trace("AdvancedWebSocketCreator called with  UUID={}", uuid);
		this.chartServiceWebSocket = new ChartServiceWebSocket(uuid);
	}

	@Override
	public Object createWebSocket(ServletUpgradeRequest req, ServletUpgradeResponse resp) {
		log.trace("@createWebSocket ==========================  Creating webSocket with UID={}",
				this.chartServiceWebSocket.getUniqueID());
		return chartServiceWebSocket;
	}
}