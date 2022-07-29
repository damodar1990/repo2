package TestAPI;

import files.payload;
import io.restassured.path.json.JsonPath;

public class complexjson1 {

	public static void main(String[] args) 
	{
		JsonPath js=new JsonPath(payload.CoursePrice());
		
		int count1=js.getInt("courses.size()");
		System.out.println(count1);
		
		int purchaseamount=js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseamount);
		
		String course1=js.getString("courses[0].title");
		System.out.println(course1);
		
		//Print All course titles and their respective Prices
		
		for(int i=0;i<count1;i++)
		{
			System.out.println(js.get("courses["+i+"].title").toString());
			
			System.out.println(js.get("courses["+i+"].price").toString());
			
		}
		
		System.out.println(js.get("courses[2].copies").toString());
		
		

	}

}
