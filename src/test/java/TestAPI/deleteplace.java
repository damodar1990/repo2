package TestAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class deleteplace {

	
	@Test
	public void deletePlace()
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
				
				//delete
				
				given().log().all().header("Content-Type","application/json")
				.body(" {\r\n"
						+ "    \"place_id\":\""+placeId+"\" \r\n"
						+ "}")
				.when().post("maps/api/place/delete/json")
				.then().log().all().statusCode(200).body("status",equalTo("OK"));
				{
					System.out.println("deleted place id:"+placeId);
				}
				
				
				
				//get
				
				 given().log().all().queryParam("key","qaclick123")
				 .queryParam("place_id", placeId)
				 .when().get("maps/api/place/get/json")
				 .then().assertThat().log().all().statusCode(404).body("msg", equalTo("Get operation failed, looks like place_id  doesn't exists"));
				 

	}

}
