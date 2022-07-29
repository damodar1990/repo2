package JiraRestAPIS;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.ReusableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class CreateIssue1 
{
	@Test
	public void addComment1()
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
		//add commment
		
		String ExpectedMessage="Any update on the issue raised";
		String role1="role";
		String response2=given().log().all().pathParam("id1",10167).header("Content-Type","application/json")
				.body("{\r\n"
						+ "	\"body\":\""+ExpectedMessage+"\",\r\n"
						+ "	\"visibility\":{\r\n"
						+ "		\"type\":\""+role1+"\",\r\n"
						+ "		\"value\":\"Administrators\"\r\n"
						+ "		\r\n"
						+ "	}\r\n"
						+ "}").filter(session)
				.when().post("rest/api/2/issue/{id1}/comment")
				.then().log().all().assertThat().statusCode(201).extract().response().asString();				
				JsonPath jpath1=ReusableMethods.rawToJson(response2);
				String ID1=jpath1.getString("id");
				System.out.println(ID1);
				
				
				//add attachment
				given().relaxedHTTPSValidation().
				header("X-Atlassian-Token","no-check").filter(session).pathParam("id1",10167)
				.header("Content-Type","multipart/form-data")
				.multiPart("file",new File("jira.txt")).log().all()
				.when().post("rest/api/2/issue/{id1}/attachments")
				.then().log().all().assertThat().statusCode(200);
			//get	
				String issue=given().pathParam("id1",10167).filter(session)
						.queryParam("fields","comment")
				.when().get("rest/api/2/issue/{id1}")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
				
				JsonPath jpath3=new JsonPath(issue);
				int commentcount=jpath3.getInt("fields.comment.comments.size()");
				for(int i=0;i<commentcount;i++)
				{
				String Cid=(jpath3.get("fields.comment.comments["+i+"].id").toString());
				System.out.println(Cid);
				if(Cid.equalsIgnoreCase(ID1))
				{
					String message=jpath3.get("fields.comment.comments["+i+"].body").toString();
					System.out.println(message);
					Assert.assertEquals(message,ExpectedMessage);
				}
				}
				
	   
	}
}