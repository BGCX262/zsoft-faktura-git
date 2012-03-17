package no.zsoft.multitenant.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TenantSecurityContextFilter implements Filter {
	
	/** The constant SPRING_SECURITY_CHECK_MAPPING.
	 ** TODO Is this constant available somewhere in Spring?
	 **/
	private static final String SPRING_SECURITY_CHECK_MAPPING = "/processlogin";
	
	/** The constant SPRING_SECURITY_LOGOUT_MAPPING.
	 ** TODO Is this constant available somewhere in Spring?
	 **/
	private static final String SPRING_SECURITY_LOGOUT_MAPPING = "/logout";	

	/** The constant TENANT_HTTP_KEY. **/
	private static final String TENANT_HTTP_KEY = "tenant";

	/** Logger. */
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	/** The filter config. */
	private FilterConfig filterConfig;
	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		//this.filterConfig = filterConfig;		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		//this.filterConfig = null;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
//		if (null == filterConfig) {
//			return;
//		}
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		// Clear tenant security context holder, and if it's a logout request then clear tenant attribute from the session
		ThreadLocalContextUtil.clearTenant();
		if (httpRequest.getRequestURI().endsWith(SPRING_SECURITY_LOGOUT_MAPPING)) {
			httpRequest.getSession().removeAttribute(TENANT_HTTP_KEY);
		}
		
		// Resolve Tenant ID
		String tenantID = null;		
		if (httpRequest.getRequestURI().endsWith(SPRING_SECURITY_CHECK_MAPPING)) {
			tenantID = request.getParameter(TENANT_HTTP_KEY);
			httpRequest.getSession().setAttribute(TENANT_HTTP_KEY, tenantID);
		} else {
			tenantID = (String) httpRequest.getSession().getAttribute(TENANT_HTTP_KEY);
		}
				
		// If found, set the Tenant ID in the security context
		if (null != tenantID) {			
			ThreadLocalContextUtil.setTenantId(tenantID);		
			if (logger.isInfoEnabled()) logger.info("Tenant context set with Tenant ID: " + tenantID);			
		}		
		
		chain.doFilter(request, response);		
	}
	
}

