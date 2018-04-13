package org.charts.dataviewer.service;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.jetty.websocket.api.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class ChartsOpenedConnections {

	private static final Logger log = LoggerFactory.getLogger(ChartsOpenedConnections.class);

	private static final ChartsOpenedConnections INSTANCE = new ChartsOpenedConnections();

	public static ChartsOpenedConnections getInstance() {
		return INSTANCE;
	}

	protected ChartsOpenedConnections() {
	}

	private Multimap<Integer, Session> openedSessions = ArrayListMultimap.create();
	private Multimap<Integer, String> unsentMessagesMap = ArrayListMultimap.create();

	public synchronized void addConnection(ChartServiceWebSocket socket) {
		Integer udId = socket.getUniqueID();
		log.debug("Adding in multimap : {} ", udId);
		openedSessions.put(udId, socket.getSession());
		if (!(unsentMessagesMap.get(socket.getUniqueID()).isEmpty())) {
			final Multimap<Integer, String> tempMessages = ArrayListMultimap.create(unsentMessagesMap);
			Collection<String> collection = new HashSet<>(tempMessages.get(udId));
			if (!collection.isEmpty()) {
				for (Iterator<String> it = collection.iterator(); it.hasNext();) {
					String payload = it.next();
					log.debug("Sent {} ", udId);
					sendMessage(udId, payload);
				}
			}

			// Resend only config messages.
			final Multimap<Integer, String> tempMessages2 = ArrayListMultimap.create(unsentMessagesMap);
			Collection<String> collection2 = new HashSet<>(tempMessages2.get(udId));
			if (!collection2.isEmpty()) {
				for (Iterator<String> it = collection2.iterator(); it.hasNext();) {
					String payload = it.next();
					if (payload.contains("PAYLOAD"))
						unsentMessagesMap.remove(udId, payload);
				}
			}
		}
	}

	public synchronized void closeConnection(ChartServiceWebSocket socket) {
		log.debug("Closed connection @ {}", socket.hashCode());
		openedSessions.remove(socket.getUniqueID(), socket.getSession());
	}

	public void sendMessage(int target, String payload) {
		for (Session session : openedSessions.get(target)) {
			try {
				session.getRemote().sendString(payload);
			} catch (IOException ex) {
				log.error("IOException : ", ex);
			}
		}

		if (openedSessions.get(target).isEmpty()) {
			log.debug("Keeped unsent message for : {}", target);
			unsentMessagesMap.put(target, payload);
		}
	}

}
