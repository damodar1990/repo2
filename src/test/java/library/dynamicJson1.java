package library;

import org.testng.annotations.Test;

import files.ReusableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;


public class dynamicJson1
{
	@Test
	public void AddBook()
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all().header("Content-Type","application/json")
		.body(payload.AddBook1("bbb","112333"))
		.when().post("Library/Addbook.php")
		.then().log().all().statusCode(200).extract().response().asString();
		
		JsonPath jpath=ReusableMethods.rawToJson(response);
		String id=jpath.getString("ID");
		System.out.println(id);
		
		
		
	}

}
