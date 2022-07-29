package TestNgPraApril.TestNgPraApril;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AppTest4 
{
	@Test(groups= {"smoke"})
	public void DoUserRegistration()
	{
		String ExepctedResult="abc";
		String ActualResult="cde";
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(ActualResult,ExepctedResult );
		
		System.out.println("continuing next lines");
		soft.assertAll();
		

		
	}
	@Test(dependsOnMethods="DoUserRegistration", groups= {"regression"})
	public void login()
	{
		System.out.println("Executing do login test");
		String ExepctedResult="abc";
		String ActualResult="abc";
		
	    Assert.assertEquals(ActualResult,ExepctedResult,"Text is mismatched");
		System.out.println("after the hard assertion");
	}

}




