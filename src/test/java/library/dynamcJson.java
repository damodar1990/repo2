package library;

import org.testng.annotations.Test;

import files.ReusableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class dynamcJson
{
	
	@Test
	public void AddBook(String isbn,String aisle)
	{
		
		RestAssured.baseURI="http://216.10.245.166";
		String Response=given().log().all().header("Content-Type","application/json")
		.body(payload.Addbook("12wee","r455rr"))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		
		JsonPath jspath=ReusableMethods.rawToJson(Response);
		String id=jspath.getString("ID");
		System.out.println(id);
		

		
		
		
		
	}

}
