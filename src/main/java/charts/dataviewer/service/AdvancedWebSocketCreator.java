package charts.dataviewer.service;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdvancedWebSocketCreator implements WebSocketCreator {

	private final static Logger logger = LoggerFactory.getLogger(AdvancedWebSocketCreator.class.getName());

	private ChartServiceWebSocket chartServiceWebSocket;

	public Map<Integer, Integer> uuidMap = new HashMap<Integer, Integer>();

	public AdvancedWebSocketCreator(int uuid) {
		logger.trace("AdvancedWebSocketCreator called with  UUID={}", uuid);
		this.chartServiceWebSocket = new ChartServiceWebSocket(uuid);
	}

	@Override
	public Object createWebSocket(ServletUpgradeRequest req, ServletUpgradeResponse resp) {
		logger.trace("@createWebSocket ==========================  Creating webSocket with UID={}", this.chartServiceWebSocket.getUniqueID());
		return chartServiceWebSocket;
	}
}