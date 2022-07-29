package TestAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class getplace {

	@Test
	public void getPlace()
	{
		//AddPlace
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","Application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
		
		.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		JsonPath jpath=new JsonPath(response);
		String placeId=jpath.getString("place_id");
		System.out.println("Place id is:"+placeId);
	
	//update place 
		String newAddress="Karkala";
		
	 given().log().all().queryParam("key","qaclick123").header("Content-Type","Application/json")
	.body("{\r\n"
			+ "\"place_id\":\""+placeId+"\",\r\n"
			+ "\"address\":\""+newAddress+"\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}").
	when().put("maps/api/place/update/json").
	then().log().all().statusCode(200).assertThat().body("msg", equalTo("Address successfully updated"));
	 
	 
	 //get place
	 given().log().all().queryParam("key","qaclick123")
	 .queryParam("place_id", placeId)
	 .when().get("maps/api/place/get/json")
	 .then().assertThat().log().all().statusCode(200).body("address", equalTo("karkala"));
	 
		

	}

}
