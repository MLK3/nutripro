package br.com.nutriproapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloWorldResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return "Hello World!";
    }
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
    @Path("{username}")
    public String getHello(@PathParam("username") String userName) {
        return "Hi " + userName;
    }
	
	@GET
	@Produces("text/html")
    public String getHello2() {
        return "<html><body>Hello</body></html>";
    }

}
