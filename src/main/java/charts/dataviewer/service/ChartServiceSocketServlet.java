package charts.dataviewer.service;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import charts.dataviewer.utils.StaticVariables;

public class ChartServiceSocketServlet extends WebSocketServlet {

	private static final long serialVersionUID = -624546172506336056L;

	private final static Logger logger = LoggerFactory.getLogger(ChartServiceSocketServlet.class.getName());

	private int uuid;

	public ChartServiceSocketServlet(int uuid) {
		logger.trace("ChartserviceSocketServlet constructor called ! ");
		this.uuid = uuid;
	}

	@Override
	public void configure(WebSocketServletFactory factory) {
		logger.trace("CALL TO CONFIGURE__ {} ", uuid);
		factory.getPolicy().setIdleTimeout(StaticVariables.WS_TIMEOUT);
		factory.setCreator(new AdvancedWebSocketCreator(uuid));
	}

}