package org.charts.dataviewer.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.websocket.api.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class ChartsOpenedConnections {

	private static final Logger log = LoggerFactory.getLogger(ChartsOpenedConnections.class);

	private static final ChartsOpenedConnections INSTANCE = new ChartsOpenedConnections();

	private Multimap<String, Session> openedSessions = ArrayListMultimap.create();

	private Map<String, String> lastPlotData = new HashMap<>();
	private Map<String, String> lastConfig = new HashMap<>();

	public static ChartsOpenedConnections getInstance() {
		return INSTANCE;
	}

	protected ChartsOpenedConnections() {
		// Protected
	}

	public synchronized void addConnection(ChartServiceWebSocket socket) {
		String udId = socket.getUniqueID();
		log.debug("Adding in multimap : {} ", udId);
		openedSessions.put(udId, socket.getSession());
	}

	public synchronized void closeConnection(ChartServiceWebSocket socket) {
		log.debug("Closed connection @ {}", socket.hashCode());
		openedSessions.remove(socket.getUniqueID(), socket.getSession());
	}

	// Maybe should be sync
	public void sendMessage(String target, String payload) {
		for (Session session : openedSessions.get(target)) {
			try {
				if (session.isOpen()) {
					session.getRemote().sendString(payload);
				}
			} catch (IOException ex) {
				log.error("IOException : ", ex);
			}
		}
		if (payload.contains("PAYLOAD")) {
			lastPlotData.put(target, payload);
		} else {
			lastConfig.put(target, payload);
		}
	}

	// Maybe should be sync
	public void resendLastMsg(String target, Session session) {
		try {
			if (session.isOpen()) {
				session.getRemote().sendString(lastPlotData.get(target));
				session.getRemote().sendString(lastConfig.get(target));
			}
		} catch (IOException ex) {
			log.error("IOException : ", ex);
		}
	}

}
