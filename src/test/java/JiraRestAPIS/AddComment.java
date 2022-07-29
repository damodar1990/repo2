package JiraRestAPIS;

import org.testng.annotations.Test;

import files.ReusableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import java.io.File;

public class AddComment 
{
	@Test	
public void addComment()
{
   RestAssured.baseURI="http://localhost:8080";	
   SessionFilter session=new SessionFilter();
   String response= given().header("Content-Type","application/json")
   .body("{ \r\n"
   		+ "\"username\": \"damusept13\",\r\n"
   		+ "\"password\": \"damodar@1990\"\r\n"
   		+ "}").log().all().filter(session)
   .when().post("rest/auth/1/session")
   .then().log().all().assertThat().statusCode(200).extract().response().asString();
   
   
  // create issue
  
	String response1=given().header("Content-Type","application/json").log().all()
	.body(payload.Cissue()).filter(session)
	
	.when().post("rest/api/2/issue")
	.then().log().all().assertThat().statusCode(201).extract().response().asString();
	
	JsonPath jpath=ReusableMethods.rawToJson(response1);
	String ID=jpath.getString("id");
	System.out.println(ID);
   
	//addcomment	
	
	String response2=given().log().all().pathParam("id1",ID).header("Content-Type","application/json")
	.body("{\r\n"
			+ "	\"body\":\"Hey ,any update on the above issue,Plz reply at the earliest\",\r\n"
			+ "	\"visibility\":{\r\n"
			+ "		\"type\":\"role\",\r\n"
			+ "		\"value\":\"Administrators\"\r\n"
			+ "		\r\n"
			+ "	}\r\n"
			+ "}").filter(session)
	.when().post("rest/api/2/issue/{id1}/comment")
	.then().log().all().assertThat().statusCode(201).extract().response().asString();
	
	JsonPath jpath1=ReusableMethods.rawToJson(response2);
	jpath1.getString("id1");
	System.out.println(ID);
	
	
	//Add Attachment
	
	given().header("X-Atlassian-Token","no-check").filter(session).pathParam("id1",ID)
	.header("Content-Type","multipart/form-data")
	.multiPart("file",new File("jira.txt")).log().all()
	.when().post("rest/api/2/issue/{id1}/attachments")
	.then().log().all().assertThat().statusCode(200);
	
	
	//get issue
	
	String issue=given().pathParam("id1",ID).filter(session)
			.queryParam("fields","comment")
	.when().get("rest/api/2/issue/{id1}")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println(issue);
	
	
	
	
}
	

	
	
	

}
