package QAuth;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;



public class SerializeTest 
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
		
		Response res=given().queryParam("key", "qaclick123")
		.body(p)
		.when().post("maps/api/place/add/json")
		.then().log().all(). assertThat().statusCode(200).extract().response();
		
		String resbody=res.asString();
		System.out.println(resbody);
	}

}
