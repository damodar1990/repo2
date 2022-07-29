package QAuth;
import static io.restassured.RestAssured.given;

public class qAuth {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C://chromeDriver.exe");
		
		given().queryParam("access_token", "");
		//.when().
	}

}


