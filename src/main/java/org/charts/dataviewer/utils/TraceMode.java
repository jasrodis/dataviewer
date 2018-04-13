package org.charts.dataviewer.utils;

import com.google.gson.annotations.SerializedName;

public enum TraceMode {
	
    @SerializedName("lines")
    LINES("lines"),
    @SerializedName("markers")
    MARKERS("markers"),
    @SerializedName("markers+lines")
    MARKERS_AND_LINES("markers+lines");

    private final String mode;

    private TraceMode(final String text) {
        this.mode = text;
    }

    @Override
    public String toString() {
        return mode;
    }

}
