package za.co.invoketech.store.application.config;

import java.io.IOException;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class GuiceFacesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FacesServlet servlet;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		servlet.init(config);
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		servlet.service(request, response);
	}

	@Override
	public void destroy() {
		servlet.destroy();
	}
}
