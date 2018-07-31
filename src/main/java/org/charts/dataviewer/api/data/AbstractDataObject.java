package org.charts.dataviewer.api.data;

import com.google.gson.Gson;

public class AbstractDataObject<T> {

	protected transient Gson gson = new Gson();

	protected T[] xArray;
	protected T[] yArray;
	protected T[] zArray;

	/**
	 * Returns array of x axis data
	 * 
	 * @return T[] x axis elements.
	 */
	public T[] getxArray() {
		return xArray;
	}

	/**
	 * Set the x axis array
	 * 
	 * @param xArray[] 
	 */
	public void setxArray(T[] xArray) {
		this.xArray = xArray;
	}
	
	/**
	 * Returns array of y axis data
	 * 
	 * @return T[] y axis elements.
	 */
	public T[] getyArray() {
		return yArray;
	}

	/**
	 * Set the x axis array
	 * 
	 * @param yArray[] 
	 */
	public void setyArray(T[] yArray) {
		this.yArray = yArray;
	}

	/**
	 * Returns array of z axis data
	 * 
	 * @return T[] z axis elements.
	 */
	public T[] getzArray() {
		return zArray;
	}

	/**
	 * Set the z axis array
	 * 
	 * @param zArray[] 
	 */
	public void setzArray(T[] zArray) {
		this.zArray = zArray;
	}

}
