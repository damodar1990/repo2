package TestAPI;

import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;


public class sumvalidation 
{
	@Test
	public void getSumValidation()
	{
		JsonPath js=new JsonPath(payload.CoursePrice());
		int count=js.getInt("courses.size()");
		for(int i=0;i<count;i++)
	   {
			int price=js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			int amount=price*copies;
			System.out.println(amount);
			
			
			
		}
		
		
	}
}
	
	
