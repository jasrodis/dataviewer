package org.charts.dataviewer.service;

import java.net.URL;

import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomResourceHandler extends ResourceHandler {

	private static final Logger log = LoggerFactory.getLogger(CustomResourceHandler.class);

	public void setResourceBase(URL resourceBase) {
		try {
			setBaseResource(Resource.newResource(resourceBase));
		} catch (Exception e) {
			log.warn("Error in CustomResourceHandler :", e);
			throw new IllegalArgumentException(resourceBase.toExternalForm());
		}
	}

}
