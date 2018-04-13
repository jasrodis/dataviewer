package org.charts.dataviewer.utils;

public enum TraceColour {
	RED("RED"), GREEN("GREEN"), BLUE("BLUE"), YELLOW("YELLOW"), CYAN("CYAN"), BLACK("BLACK"), ORANGE("ORANGE"), PURPLE("PURPLE");

	private final String colour;

	private TraceColour(final String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return colour;
	}

}
