package pojo;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;



public class SpecBuilderTest 
{
	public static void main(String[] args) {
	
		RestAssured.baseURI="https://rahulshettyacademy.com";
		AddPlace p=new AddPlace();
		
		p.setAccuracy(50);
		
		p.setAddress("bola,karkala ,574110");
		
		
		
		p.setLanguage("Kannada");
		p.setPhone_no("7353610391");
		p.setName("damodar");
		p.setWebsite("https://rahulshettyacademy.com");
		
		List <String> s1=new ArrayList<String>();
		s1.add("shoe park");
		s1.add("shop");
		p.setTypes(s1);
		
		Location loc=new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
	
		p.setLocation(loc);
		
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
		.setContentType(ContentType.JSON).build();
		
		ResponseSpecification resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		RequestSpecification req1=given().spec(req)
		.body(p);
		
		Response response=req1
				.when().post("maps/api/place/add/json")
		.then().spec(resspec).extract().response();
		
		String responseString=response.asString();
		System.out.println(responseString);
	}

}

