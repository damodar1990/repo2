package library;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReusableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;


public class parameterDataProvider 
{
	@Test(dataProvider="BooksData")
	public void Addbook(String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
	    String response=given().log().all().header("Content-Type","application/json")
		.body(payload.AddBook1(isbn, aisle))
		.when().post("Library/Addbook.php")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
	    
	    JsonPath jpath=ReusableMethods.rawToJson(response);
	    String id=jpath.getString("ID");
	    System.out.println(id);	
		
		
	
}
	
	@DataProvider(name="BooksData")
	public Object[][] GetBook()
	{
		return new Object[][] {{"adced11","9871i7"},{"adecf22","12bb22y11"},{"aadsf09","514rer"}};
		
	}

}
