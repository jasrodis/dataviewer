![Smaller icon](Documentation/images/logo.png?raw=true 'Dataviewer')

[![Build Status](https://travis-ci.org/jasrodis/dataviewer.svg?branch=master)](https://travis-ci.org/jasrodis/dataviewer) [![](https://jitpack.io/v/jasrodis/dataviewer.svg)](https://jitpack.io/#jasrodis/dataviewer) [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Do you want to create a chart and easily share it with a link? Check out this project!

Dataviewer is an open-source data visualization tool for Java.

It is based on [Plotly.js](https://plot.ly/javascript/), [Jetty](http://www.eclipse.org/jetty/) and Websockets.

## Dataviewer Examples

Extensive usage of the DataViewer with examples can be found: [http://github.com/jasrodis/dataviewer-example](http://github.com/jasrodis/dataviewer-example)

## JavaFX wrapper library

There is a JavaFX wrapper library that displays your charts to both JavaFX and the web!

* JavaFxDataViewer with examples can be found: [http://github.com/jasrodis/javafx-dataviewer-example](http://github.com/jasrodis/javafx-dataviewer-example)

## Requirements

* Recent version of Java installed (Jdk8+).

## To install the library to your project!

Maven JitPack installation:

```xml
<dependency>
  <groupId>com.github.jasrodis</groupId>
  <artifactId>dataviewer</artifactId>
  <version>-SNAPSHOT</version>
</dependency>
```

## API

* DataViewer
* DataViewerConfiguration
* Trace
* TraceConfiguration
* PlotData

#### DataViewer & DataViewerConfiguration

DataViewer is the main plotting window. It is configured by the DataViewerConfiguration.

With DataViewer you can:

1.  Update your Plot Configuration
2.  Update your Plot Data
3.  Reset your Plot Data

##### DataViewer

```java
updatePlot(PlotData data);                               // Updates the plot
updatePlotConfiguration(DataViewerConfiguration config); // Updates the dataviewer (window) configuration.
getUniqueID(); // Get the unique ID of the dataviewer -  // navigate http://localhost:8090/view/UNIQUE_ID/
```

##### DataViewerConfiguration

```java
setPlotTitle(String title);              // plot title
setxAxisTitle(String title);             // x axis title
setyAxisTitle(String title);             // x axis title
setMarginTop(int margin);                // margin top
setMarginBottom(int margin);             // margin bottom
setMarginRight(int margin);              // margin right
setMarginLeft(int margin);               // margin left
setPadding(int padding);                 // padding
setxRange(double min, double max);       // Set the range of the x axis of the dataviewer
setyRange(double min, double max);       // Set the range of the x axis of the dataviewer
setxAxisType(AxisType type);             // Set the axis type of x axis (log or linear)
setyAxisType(AxisType type);             // Set the axis type of y axis (log or linear)
showLegend(boolean set);                 // Show/hide Legend
setLegendInsidePlot(boolean inside);     // Show legend inside plot
```

See usage example below:

```java
// Create dataviewer
DataViewer dataviewer = new DataViewer();

// Create dataviewer configuration
DataViewerConfiguration config = new DataViewerConfiguration();
// Plot title
config.setPlotTitle("Line Trace Example");
// X axis title
config.setxAxisTitle("X Example 1");
// Y axis title
config.setyAxisTitle("Y Example 1");

// Update the configuration
dataviewer.sendConfiguration(config);

// Container of traces
PlotData plotData = new PlotData(new LineTrace<Float>());

// Plot all traces in the container.
dataviewer.updatePlot(plotData);
```

Resetting the dataviewer example:

```java
DataViewer dataviewer = new DataViewer();
DataViewerConfiguration config = new DataViewerConfiguration();
dataviewer.sendConfiguration(config);
PlotData plotData = new PlotData();
dataviewer.updatePlot(plotData);

// Reset your Plot (removes all trace from the dataviewer)
dataviewer.resetPlot();
```

#### Traces

Traces are the different kind of plots that are going to be drawed in the DataViewer. Provided Traces:

* `GenericTrace<T>`
* `LineTrace<T>`
* `ScatterTrace<T>`
* `BarTrace<T>`
* `TimeSeriesTrace<T>`
* `HistogramTrace<T>`
* `ContourTrace<T>`

More to be provided..

##### GenericTrace

GenericTrace is an abstract class that all traces inherit from.

It can be used as a container when the type of the trace is not known.

See usage example below:

    Methods:

```java
// Config
setTraceName(String traceName);                          // Updates the plot
setConfiguration(TraceConfiguration traceConfig)         // Set the trace configuration
setTraceColour(TraceColour colour);                      // Set trace Colour
setTraceMode(TraceMode mode);                            // Set the trace mode (LINES, MARKERS, MARKERS_AND_LINES)
setTraceType(TraceType traceType);                       // Set the trace Type (BAR, LINE, SCATTER, CONTOUR ...)
setTraceVisibility(TraceVisibility visibility);          // Visibility of the trace(TRUE, FALSE, LEGENDONLY)

// Data
setxAxis(T[] xAxis);
setyAxis(T[] xAxis);
setzAxis(T[] zAxis);
```

##### GenericTrace Example - abstract class ( should not be used like this! )

```java
GenericTrace<Double> genericTrace = new LineTrace<>();
genericTrace.setxArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
genericTrace.setyArray(new Double[]  { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
genericTrace.setTraceColour(TraceColour.PURPLE);
genericTrace.setTraceName("Line Trace");
genericTrace.setTraceType(TraceType.LINE);
genericTrace.setTraceMode(TraceMode.LINES);
genericTrace.setTraceVisibility(TraceVisibility.TRUE);
```

##### LineTrace

![Smaller icon](Documentation/images/Line.png?raw=true 'LineTrace example')

Example:

```java
LineTrace<Double> lineTrace = new LineTrace<>();
lineTrace.setTraceName("MyLineTrace");
lineTrace.setxArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
lineTrace.setyArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
lineTrace.setTraceColour(TraceColour.PURPLE);
```

Example with configuration object:

```java
LineTrace<Double> lineTrace = new LineTrace<>();
lineTrace.setTraceName("MyLineTrace");

lineTrace.setxArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
lineTrace.setyArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });

TraceConfiguration lineConfig = new TraceConfiguration();
lineConfig.setTraceColour(TraceColour.RED);
lineTrace.setConfiguration(lineConfig);
```

##### BarTrace

![Smaller icon](Documentation/images/Bar.png?raw=true 'BarTrace example')

Example:

```java
BarTrace<Object> barTrace = new BarTrace<>();
barTrace.setTraceName("MyBarTrace");
barTrace.setxArray(new String[] { "one", "two", "three", "four", "five", "six" });
barTrace.setyArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
barTrace.setTraceColour(TraceColour.PURPLE);
```

Example with configuration object:

```java
BarTrace<Object> barTrace = new BarTrace<>();
barTrace.setTraceName("MyBarTrace");

barTrace.setxArray(new String[] { "one", "two", "three", "four", "five", "six" });
barTrace.setyArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });

TraceConfiguration barConfig = new TraceConfiguration();
barConfig.setTraceColour(TraceColour.RED);
barTrace.setConfiguration(barConfig);
```

##### ScatterTrace

![Smaller icon](Documentation/images/Scatter.png?raw=true 'ScatterTrace example')

Example:

```java
Scatter<Float> scatterTrace = new ScatterTrace<>();
scatterTrace.setTraceName("MyScatterTrace");
scatterTrace.setxArray(new Float[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
scatterTrace.setyArray(new Float[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
scatterTrace.setTraceColour(TraceColour.PURPLE);
```

Example with configuration object:

```java
ScatterTrace<Double> scatterTrace = new ScatterTrace<>();
scatterTrace.setTraceName("MyScatterTrace");

scatterTrace.setxArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
scatterTrace.setyArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });

TraceConfiguration scatterConfig = new TraceConfiguration();
scatterConfig.setTraceColour(TraceColour.RED);
scatterTrace.setConfiguration(scatterConfig);
```

##### TimeSeriesTrace

![Smaller icon](Documentation/images/TimeSeries.png?raw=true 'ScatterTrace example')

Example:

```java
TimeSeries<Object> timeSeriesTrace = new TimeSeriesTrace<>();
timeSeriesTrace.setTraceName("MyTimeSeriesTrace");

timeSeriesTrace.setxArray(new String[] { "2013-10-04 22:23:00", "2013-10-05 22:23:01", "2013-10-06 22:23:02", "2013-10-07   22:23:03", "2013-10-08 22:23:04", "2013-10-09 22:23:05", "2013-10-10 22:23:06" });
timeSeriesTrace.setyArray(new Float[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });

timeSeriesTrace.setTraceColour(TraceColour.PURPLE);
```

Example with configuration object:

```
TimeSeriesTrace<Double> timeSeriesTrace = new TimeSeriesTrace<>();
timeSeriesTrace.setTraceName("MyTimeSeriesTrace");

timeSeriesTrace.setxArray(new String[] { "2013-10-04 22:23:00", "2013-10-05 22:23:01", "2013-10-06 22:23:02", "2013-10-07   22:23:03", "2013-10-08 22:23:04", "2013-10-09 22:23:05", "2013-10-10 22:23:06" });
timeSeriesTrace.setyArray(new Float[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });

TraceConfiguration timeSeriesConfig = new TraceConfiguration();
timeSeriesTrace.setTraceColour(TraceColour.RED);
timeSeriesTrace.setConfiguration(timeSeriesConfig);
```

##### CountourTrace

![Smaller icon](Documentation/images/Contour.png?raw=true 'Contour example')

Example:

```java
ContourTrace<Double> contourTrace = new ContourTrace<>();

contourTrace.setxArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });
contourTrace.setyArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });
contourTrace.setzArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });

contourTrace.setTraceName("ContourTrace");
```

Example with configuration object:

```java
ContourTrace<Double> contourTrace = new ContourTrace<>();

contourTrace.setxArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });
contourTrace.setyArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });
contourTrace.setzArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });

TraceConfiguration contourConfig = new TraceConfiguration();
contourConfig.setTraceName("ContourTrace");

contourTrace.setConfiguration(contourConfig);
```

##### Histogram

![Smaller icon](Documentation/images/Histogram.png?raw=true 'HistogramTrace example')

Example:

```java
HistogramTrace<Double> histogramTrace = new HistogramTrace<>();
histogramTrace.setxArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });
histogramTrace.setTraceName("MyHistogramTrace");
histogramTrace.setTraceColour(TraceColour.BLUE);
```

Example with configuration object:

```java
HistogramTrace<Double> histogramTrace = new HistogramTrace<>();
histogramTrace.setxArray(new Double[] { 0.0, 1.0, 200.0, 3.0, 4000.0, 5.0 });

TraceConfiguration histogramConfig = new TraceConfiguration();
histogramConfig.setTraceName("HistogramTrace");
histogramConfig.setTraceColour(TraceColour.RED);

histogramTrace.setConfiguration(histogramConfig);
```

## Features

### plotly.js features

You can find plotly features here: [http://help.plot.ly/getting-to-know-the-plotly-modebar/](http://help.plot.ly/getting-to-know-the-plotly-modebar/)

## Architecture Overview

DataViewer uses the embedded Jetty Server in order to create Websocket Endpoints and Serve Static Html & Javascript pages. These pages can be found under http://localhost:8090/view/{your_name}

**Overview of the architecture:**

![Smaller icon](Documentation/images/Architecture.png 'Local Catalog Configuration')

#### Sequence diagram

![Smaller icon](Documentation/images/Architecture2.png 'Local Catalog Configuration')
