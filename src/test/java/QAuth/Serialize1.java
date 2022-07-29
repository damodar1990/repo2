package QAuth;
import static io.restassured.RestAssured.given;



import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Session;

public class Serialize1 
{
	
	public static void main(String[] args) {
	
	{
			RestAssured.baseURI="http://localhost:8080";
			
			Session s=new Session();
			s.setUsername("damusept13");
			s.setPassword("damodar@1990");
			
			RequestSpecification req=new RequestSpecBuilder().setBaseUri("http://localhost:8080").setContentType(ContentType.JSON).build();
			
			ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
					
			RequestSpecification req1=given().spec(req)
					.body(s);
		    Response response=req1
		    		.when().post("rest/auth/1/session")
			.then().spec(res).extract().response();
			
			String resbody=response.asString();
			System.out.println(resbody);
		
	}
	

}
}
