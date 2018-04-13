package org.charts.dataviewer.utils;

import com.google.gson.annotations.SerializedName;

public enum TraceVisibility {
	
    @SerializedName("true")
    TRUE("true"),
    @SerializedName("false")
    FALSE("false"),
    @SerializedName("legendonly")
    LEGENDONLY("legendonly");
    
    private final String traceVisibility;

    private TraceVisibility(final String traceVisibility) {
        this.traceVisibility = traceVisibility;
    }

    @Override
    public String toString() {
        return traceVisibility;
    }
}

