package TestAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import files.payload;

public class AddPlace {

	@Test
	public void AddPlace1() 
	{
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","Application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
		
		.then().log().all().assertThat().statusCode(200);
		
	}
	@Test
	public void AddValidation()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","Application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
		
		.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		JsonPath jpath=new JsonPath(response);
		String placeId=jpath.getString("place_id");
		System.out.println("Place id is:"+placeId);	
		
	}

}
