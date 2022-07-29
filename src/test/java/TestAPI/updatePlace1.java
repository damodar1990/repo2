package TestAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import files.payload;

public class updatePlace1 {

	@Test
	public void updatePlace11() {
		

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "Application/json")
				.body(payload.AddPlace()).when().post("maps/api/place/add/json")

				.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();

		System.out.println(response);
		JsonPath jpath = new JsonPath(response);
		String placeId = jpath.getString("place_id");
		System.out.println("Place id is:" + placeId);

		String newAddress = "Karkala";

		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "Application/json")
				.body("{\r\n" + "\"place_id\":\"" + placeId + "\",\r\n" + "\"address\":\"" + newAddress + "\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}")
				.when().put("maps/api/place/update/json").then().log().all().statusCode(200).assertThat()
				.body("msg", equalTo("Address successfully updated"));

	}

	@Test(enabled = true)
	public void updatePlaceWithBlankAddress() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "Application/json")
				.body(payload.AddPlace()).when().post("maps/api/place/add/json")

				.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();

		System.out.println(response);
		JsonPath jpath = new JsonPath(response);
		String placeId = jpath.getString("place_id");
		System.out.println("Place id is:" + placeId);

		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "Application/json")
				.body("{\r\n" + "\"place_id\":\"" + placeId + "\",\r\n" + "\"address\":\"\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}")
				.when().put("maps/api/place/update/json").then().log().all().statusCode(200).assertThat()
				.body("msg", equalTo("Address successfully updated"));

	}

}
