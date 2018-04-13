package org.charts.dataviewer.api.data;

import com.google.gson.Gson;

/**
 * Data message to reset the Dataviewer
 *  
 * @author jasrodis
 */
public class ResetData {

	protected final String type = "RESET";
	
	private final transient Gson gson = new Gson();

	public String serialize() {
		return gson.toJson(this);
	}

}
