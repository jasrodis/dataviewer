package org.charts.dataviewer.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.ServerSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DataViewerUtils {

	private static final Logger log = LoggerFactory.getLogger(DataViewerUtils.class);

	private DataViewerUtils() {
		// Protecting from instantiation
	}

	public static boolean available(int port) {
		if (port < StaticVariables.MIN_PORT || port > StaticVariables.MAX_PORT) {
			throw new IllegalArgumentException("Invalid start port: " + port);
		}
		ServerSocket ss = null;
		DatagramSocket ds = null;
		try {
			ss = new ServerSocket(port);
			ss.setReuseAddress(true);
			ds = new DatagramSocket(port);
			ds.setReuseAddress(true);
			return true;
		} catch (IOException e) {
			log.error("Exception in availiable()", e);
		} finally {
			if (ds != null) {
				ds.close();
			}

			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					log.error("Exception in availiable() when closing the socket", e);
				}
			}
		}
		return false;
	}

	public static String readFile(InputStream inputStream) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}
	}
}
