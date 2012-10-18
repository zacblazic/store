package za.co.invoketech.store.application.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.primefaces.webapp.filter.FileUploadFilter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class GuiceFileUploadFilter implements Filter {
	
	@Inject
	private FileUploadFilter filter;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		filter.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		filter.doFilter(arg0, arg1, arg2);
	}
	
	@Override
	public void destroy() {
		filter.destroy();
	}
}
