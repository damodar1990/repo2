package HashMap;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import files.ReusableMethods;
import files.payload;


public class HashMapData 
{
	@Test
	public void getdata()
	{
		

		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "RestAssured");
		map.put("isbn", "rre323113");
		map.put("aisle", "jjy53311");
		map.put("author", "damodar");
		
		RestAssured.baseURI="http://216.10.245.166";

		
		String response=given().log().all().header("Content-Type","application/json")
		.body(map)
		.when().post("/Library/Addbook.php/ ")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath jpath=ReusableMethods.rawToJson(response);
		String Id=jpath.getString("ID");
		System.out.println(Id);
	}

}
