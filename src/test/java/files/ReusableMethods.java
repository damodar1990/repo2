package files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

	public static JsonPath rawToJson(String response)
	{
		JsonPath jspath=new JsonPath(response);
		return jspath;
		
	}

}
