package exampleWebAPI;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/swagger")
public class SwaggerResources {
	
	@GET
	@Path("/swagger.json")
	@Produces(MediaType.TEXT_PLAIN)
	public File swaggerJSON() {
	  File file = new File("C://Users/jordnelson/workspace/exampleWebAPI/Swagger/maven-output/swagger.json");
	  return file;
	}
	
//	@GET
//	@Path("/v3/{fileName}")
////	@Produces(MediaType.TEXT_HTML)
//	public File getIndex(@PathParam("fileName") String fileName) {
//	  File file = new File("C://Users/jordnelson/workspace/exampleWebAPI/Swagger/dist/v3/" + fileName);
//	  return file;
//	}
//
//	@GET
//	@Path("/v2/{path:.*.css}")
////	@Produces(MediaType.)
//	public File getIndex2(@PathParam("path") String path) {
//	  File file = new File("C://Users/jordnelson/workspace/exampleWebAPI/Swagger/dist/v2/" + path);
//	  return file;
//	}
	
//	http://localhost:8080/exampleWebAPI/example/swagger/v2/index.html
	@GET
	@Path("/{path:.*}")
//	@Produces(MediaType.TEXT_HTML)
	public File getIndex3(@PathParam("path") String path) {
	  File file = new File("C://Users/jordnelson/workspace/exampleWebAPI/Swagger/dist/" + path);
	  return file;
	}
	
	
}
