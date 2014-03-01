package helper;

import javax.servlet.http.HttpServletRequest;

public class UrlHelper {
	public static String getUrlRelativo(HttpServletRequest request, String servlet) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(request.getScheme());
		sb.append("://");
		sb.append(request.getServerName());
		
		if (request.getServerPort() != 80)
			sb.append(":" + request.getServerPort());
		
		sb.append(request.getContextPath());
		sb.append(servlet);
		
		return sb.toString();
	}
}
