package charts.dataviewer.utils;

import com.google.gson.annotations.SerializedName;

public enum TraceType {
	// Line is of type scatter (changes the traceMode)
    @SerializedName("scatter")
    LINE("scatter"),
    @SerializedName("realtime")
    REALTIME("realtime"),
    @SerializedName("scatter")
    SCATTER("scatter"),
    @SerializedName("histogram")
    HISTOGRAM("histogram"),
    @SerializedName("contour")
    CONTOUR("contour"),
    @SerializedName("bar")
    BAR("bar"),
    @SerializedName("log")
    LOG("log"),
    @SerializedName("scatter3d")
    SCATTER_3D("scatter3d"),
    @SerializedName("histogram2dcontour")
    HISTOGRAM_2D_CONTOUR("histogram2dcontour");
    
    private final String type;

    private TraceType(final String text) {
        this.type = text;
    }

    @Override
    public String toString() {
        return type;
    }
}

