package exampleWebAPI;

/**
 * @author Jordan Nelson
 */

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.swagger.annotations.*;

import exampleWebAPI.DataStore;

@Path("/user")
@Api(value="/user", description = "Operations about user")
@Produces({"application/json"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	
	
	private static DataStore data = new DataStore();

	@GET
	@Path("/")
	@ApiOperation(value = "Get list of users")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "{error: Not Found}") })
	public Response getUser() throws JSONException {

		JSONArray users = data.getUsers();
		String result = users.toString();
		return Response.status(200).entity(result).build();

	}
	
	@GET
	@Path("/{id}")
	@ApiOperation(value = "Gets and individual user based off the ID")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "{error: Not Found}") })
	public Response getUser(@ApiParam(value = "id", allowableValues="range[1,1000]") @PathParam("id") int id) throws JSONException {
		
		JSONObject user = data.getUserById(id);

		if (user.isNull("id")) {
			JSONObject error = new JSONObject();
			error.put("error", "Not Found");
			String result = error.toString();
			return Response.status(404).entity(result).build();
		} else {
			String result = user.toString();
			return Response.status(200).entity(result).build();
		}

	}
	
	@POST
	@Path("/")
	@ApiOperation(value = "Creates a new and user")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "{error: Not Found}") })
	public Response createUser(@ApiParam(value = "user object", required = true) UserModel user)  {
		JSONObject newUser = data.addUser(new JSONObject(user));
		
		if (newUser.isNull("id")) {
			JSONObject error = new JSONObject();
			error.put("error", "Error creating user");
			String result = error.toString();
			return Response.status(404).entity(result).build();
		} else {
			String result = newUser.toString();
			return Response.status(200).entity(result).build();
		}
	
	}
	
}