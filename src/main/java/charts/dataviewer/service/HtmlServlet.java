package charts.dataviewer.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import charts.dataviewer.utils.DataViewerUtils;
import charts.dataviewer.utils.StaticVariables;

public class HtmlServlet extends HttpServlet {

	private static final long serialVersionUID = 7441020952191793260L;
	private final static Logger logger = LoggerFactory.getLogger(HtmlServlet.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println(createAndGetHtmlFile(request));
	}

	public String createAndGetHtmlFile(HttpServletRequest request) {

		String uidPattern = "/view/(?<!\\d)\\d+(?!\\d)";
		Pattern pattern = Pattern.compile(uidPattern);
		Matcher matcher = pattern.matcher(request.getRequestURI());
		if (!matcher.matches()) {
			return "Bad http GET request";
		}

		InputStream fileName = getClass().getResourceAsStream(StaticVariables.HTML_FILE);
		String content;
		try {
			content = DataViewerUtils.readFile(fileName);
			content = content.replace("ws://localhost:8090/charts/0", parseUidFromUrl(request));
			return content;
		} catch (IOException ex) {
			logger.error("Failed to load: [{}]", StaticVariables.HTML_FILE, ex);
		}
		return "HtmlServlet : Error in creating static content";
	}

	public String parseUidFromUrl(HttpServletRequest request) {
		StringBuffer requestURL = request.getRequestURL();
		String content = new String(requestURL.toString());
		content = content.replaceAll("http://", "ws://");
		content = content.replaceAll("view", "charts");
		logger.debug("Served html file with endpoint :  [{}]", content);
		return content;
	}

}
