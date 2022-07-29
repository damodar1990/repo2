package JiraRestAPIS;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import files.ReusableMethods;
import files.payload;

public class createIssue
{
	@Test
	public void CreateIssue()
	{
		RestAssured.baseURI="http://localhost:8080";
		String response=given().header("Content-Type","application/json").header("Cookie","JSESSIONID=9D775C3F29B1AB74176A96F5405D2760")
		.body(payload.Cissue())
		
		.when().post("rest/api/2/issue")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		
		JsonPath jpath=ReusableMethods.rawToJson(response);
		String ID=jpath.getString("id");
		System.out.println(ID);
		
		JsonPath jspath=ReusableMethods.rawToJson(response);
		String Key=jpath.getString("key");
		System.out.println(Key);
		
		//get ss
		

		given().pathParam("id",ID).log().all(). header("Cookie","JSESSIONID=9D775C3F29B1AB74176A96F5405D2760")
		.when().get("rest/api/2/issue/{id}")
		.then().log().all().assertThat().statusCode(200);
		
		/*JsonPath jpath1=ReusableMethods.rawToJson(response1);
		String Idkey=jpath.getString("key");
		System.out.println(Idkey);*/
		
	}

}
