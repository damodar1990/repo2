package TestNgPraApril.TestNgPraApril;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AppTest2 
{
	@Test(priority=1)
	public void DoUserRegistration()
	{
		String ExepctedResult="abc";
		String ActualResult="cde";
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(ActualResult,ExepctedResult );
		
		System.out.println("continuing next lines");
		soft.assertAll();
		

		
	}
	@Test(priority=2,enabled=false)
	public void login()
	{
		System.out.println("Executing do login test");
		String ExepctedResult="abc";
		String ActualResult="abc";
	    Assert.assertEquals(ActualResult,ExepctedResult,"Text is mismatched");
		System.out.println("after the hard assertion");
	}

}
