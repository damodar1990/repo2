package HashMap;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ExcelData
{
@Test	
	public void getBook() throws IOException
	{
	DataDriven d=new DataDriven();
    ArrayList data=	d.getdata("RestAddBook");
    
    HashMap<String, Object> map = new HashMap<String, Object>();
	map.put("name", data.get(0));
	map.put("isbn", data.get(2));
	map.put("aisle", data.get(3));
	map.put("author", data.get(4));
	
	RestAssured.baseURI="http://216.10.245.166";

	
	String response=given().log().all().header("Content-Type","application/json")
	.body(map)
	.when().post("/Library/Addbook.php/ ")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	JsonPath jpath=ReusableMethods.rawToJson(response);
	String Id=jpath.getString("ID");
	System.out.println(Id);
    
	

}}

