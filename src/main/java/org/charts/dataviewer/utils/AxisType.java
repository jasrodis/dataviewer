package org.charts.dataviewer.utils;

import com.google.gson.annotations.SerializedName;

public enum AxisType {

	@SerializedName("log") LOG("log"), @SerializedName("") DEFAULT("");
	
	private final String mode;

	private AxisType(final String text) {
		this.mode = text;
	}

	@Override
	public String toString() {
		return mode;
	}

}
