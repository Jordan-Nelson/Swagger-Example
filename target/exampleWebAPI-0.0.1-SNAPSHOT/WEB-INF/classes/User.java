package exampleWebAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Jordan Nelson
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.swagger.annotations.*;

import exampleWebAPI.DataStore;

@Path("/user")
@Api(value="/user", description = "Operations about user")
@Produces({"application/json"})
public class User {
	
	
	private static DataStore data = new DataStore();

	@GET
	@Path("/")
	@ApiOperation(value = "Get list of users")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "{error: Not Found}") })
	@Produces("application/json")
	public Response getUser() throws JSONException {

		JSONArray users = data.getUsers();
		String result = "@Produces(\"application/json\") Output: \n\nUsers: \n\n" + users;
		return Response.status(200).entity(result).build();

	}
	
	@GET
	@Path("/{id}")
	@ApiOperation(value = "Gets and individual user based off the ID")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "{error: Not Found}") })
	
//	@Produces("application/json")
	public Response getUser(@ApiParam(value = "id", allowableValues="range[1,1000]") @PathParam("id") int id) throws JSONException {
		
		JSONObject user = data.getUserById(id);

		if (user.isNull("id")) {
			JSONObject error = new JSONObject();
			error.put("error", "Not Found");
			String result = "@Produces(\"application/json\") Output: \n\nUser: \n\n" + error;
			return Response.status(200).entity(result).build();
		} else {
			String result = "@Produces(\"application/json\") Output: \n\nUser: \n\n" + user;
			return Response.status(200).entity(result).build();
		}

	}

	
}
