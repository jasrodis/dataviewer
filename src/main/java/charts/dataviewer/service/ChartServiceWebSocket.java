package charts.dataviewer.service;

import java.io.IOException;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebSocket
public class ChartServiceWebSocket {

	private final static Logger logger = LoggerFactory.getLogger(ChartServiceWebSocket.class.getName());

	private int uuid;
	private Session session;

	public ChartServiceWebSocket(int uuid) {
		this.uuid = uuid;
	}

	@OnWebSocketConnect
	public void handleConnect(Session session) {
		this.session = session;
		ChartsOpenedConnections.getInstance().addConnection(this);
	}

	@OnWebSocketClose
	public void handleClose(int statusCode, String reason) {
		logger.debug("Connection Closed with statusCode = [{}] , reason = [{}], UUID : [{}]", statusCode, reason, uuid);
		ChartsOpenedConnections.getInstance().closeConnection(this);
	}

	@OnWebSocketMessage
	public void handleMessage(String message) {
		logger.debug("@OnWebSocketMessage | Received message :  {} @ {}", message, this.hashCode());
	}

	@OnWebSocketError
	public void handleError(Throwable error) {
		logger.error("@OnWebSocketError ", error);
	}

	public void sendMessage(String message) {
		try {
			if (session.isOpen()) {
				session.getRemote().sendString(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getUniqueID() {
		return uuid;
	}

	public Session getSession() {
		return session;
	}

}
