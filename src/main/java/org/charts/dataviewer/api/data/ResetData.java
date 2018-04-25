package org.charts.dataviewer.api.data;

import com.google.gson.Gson;

/**
 * Data message to reset (clear all traces) the Dataviewer
 * 
 * @author jasrodis
 */
public class ResetData {

	protected final String type = "RESET";

	private final transient Gson gson = new Gson();

	/**
	 * Serialize the ResetData object
	 * 
	 * @return serialized resetData Object
	 */
	public String serialize() {
		return gson.toJson(this);
	}

}
