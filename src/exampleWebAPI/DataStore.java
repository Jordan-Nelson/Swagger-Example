package exampleWebAPI;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataStore {
	
	//	Init vars
	public static JSONArray users = new JSONArray();
		
	private static JSONObject user1 = new JSONObject();
	private static JSONObject user2 = new JSONObject();
	private static JSONObject user3 = new JSONObject();
	
	//	Init values  
	public DataStore() {
		
		user1.put("id", 1);
		user1.put("firstName", "Jane");
		user1.put("lastName", "Doe");
		
		user2.put("id", 2);
		user2.put("firstName", "John");
		user2.put("lastName", "Smith");

		user3.put("id", 3);
		user3.put("firstName", "Joe");
		user3.put("lastName", "Johnson");
		
		users.put(user1);
		users.put(user2);
		users.put(user3);	
		
	}
	

	public static JSONArray getUsers() {
		return users;
	}
	
	public static JSONObject getUserById(int id) {
		
		JSONObject user = new JSONObject();
		for (int i = 0; i < users.length(); i++) {
			if (users.getJSONObject(i).getInt("id") == id) {
				user = users.getJSONObject(i);
			}
		}
		
		return user;
	}

	public static JSONObject addUser(JSONObject user) {
		
		int index = users.getJSONObject(users.length() - 1).getInt("id") + 1;
		user.put("id", index);
		users.put(user);
		return user;
		
	}
	
}
