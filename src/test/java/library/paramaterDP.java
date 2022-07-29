package library;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReusableMethods;
import files.payload;

public class paramaterDP 
{
	@Test(dataProvider="GetBook1")
	public void AddBook1(String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all().header("Content-Type","application/json")
	     .body(payload.AddBook2(isbn, aisle))
		.when().post("Library/Addbook.php")
		.then().assertThat().log().all(). statusCode(200).extract().response().asString();
		
		JsonPath jpath=ReusableMethods.rawToJson(response);
		String id=jpath.getString("ID");
		System.out.println(id);
	}
	
	@DataProvider(name="GetBook1")
	public Object[][] GetInfo()
	{
		return new Object[][] {{"ab1243","112red"},{"cd43433","23eeere"},{"11ggtrtr","776trtr"},{"tr5544","76ttrr"},{"66lklk","uyy666"}};
	}

}
