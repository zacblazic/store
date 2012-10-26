package za.co.invoketech.store.integration.webservices.rest.server.resource;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class TestResource extends ServerResource {
		
	@Get
	public String getMessage(){
		String aword = (String)getRequestAttributes().get("word");
		
		return "Hello" + aword;
	}
}
