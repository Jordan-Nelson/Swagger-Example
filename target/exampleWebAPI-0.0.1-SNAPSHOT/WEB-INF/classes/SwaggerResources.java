package exampleWebAPI;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/swagger")
public class SwaggerResources {
	
	@GET
	@Path("/swagger.json")
	@Produces(MediaType.APPLICATION_JSON)
	public File getFile() {
	  File file = new File("C://Users/jordnelson/workspace/exampleWebAPI/Swagger/maven-output/swagger.json");
	  return file;
	}
	
	@GET
	@Path("/index.html")
	@Produces(MediaType.TEXT_HTML)
	public File getSwaggerUI() {
	  File file = new File("C://Users/jordnelson/workspace/exampleWebAPI/Swagger/dist/index.html");
	  return file;
	}
	
}
