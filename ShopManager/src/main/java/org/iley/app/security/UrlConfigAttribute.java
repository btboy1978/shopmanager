package org.iley.app.security;

import org.springframework.security.access.ConfigAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yangyibo on 17/2/15.
 */
public class UrlConfigAttribute implements ConfigAttribute {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final HttpServletRequest httpServletRequest;

	public UrlConfigAttribute(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	@Override
	public String getAttribute() {
		return httpServletRequest.getRequestURI();
	}

	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}
}