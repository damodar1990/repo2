package TestNgPraApril.TestNgPraApril;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest1 
{
	
	
	@BeforeClass
	
	public void SetUp()
	{
		System.out.println("setup");
	}
	

	@AfterClass
	public void SetDown()
	{
		System.out.println("setup");
	}
	
	@BeforeMethod
	public void SetUp1()
	{
		System.out.println("setup");
	}
	

	@AfterMethod
	public void SetDown1()
	{
		System.out.println("setup");
	}
	
	
	@BeforeTest
	public void CreateDBconnection()
	{
		System.out.println("creating DB connection");
	}
	
	@AfterTest
	public void stopDBconnection()
	{
		System.out.println("creating DB connection");
	}
	
	
	@BeforeMethod
	public void LaunchAppiumServer()
	{
		System.out.println("Launching appium server");
	}
	
	@AfterMethod
	public void StopAppiumServer()
	{
		System.out.println("stop apipium server");
	}
	
	
	@Test
	public void DoUserRegistration()
	{
		System.out.println("Executing do registration test");
		
	}
	@Test
	public void run()
	{
		System.out.println("Executing do login test");
	}
	

}
