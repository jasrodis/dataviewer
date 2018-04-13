package charts.dataviewer.service;

import java.net.URL;

import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomResourceHandler extends ResourceHandler {

	private final static Logger logger = LoggerFactory.getLogger(CustomResourceHandler.class.getName());

	public void setResourceBase(URL resourceBase) {
		try {
			setBaseResource(Resource.newResource(resourceBase));
		} catch (Exception e) {
			logger.warn(e.toString());
			logger.debug("{}", e);
			throw new IllegalArgumentException(resourceBase.toExternalForm());
		}
	}

}
