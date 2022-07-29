package TestNgPraApril.TestNgPraApril;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AppTest5 
{
	@Test(dataProvider="getData")
	public void login(String userName,String pwd)
	{
		System.out.println("Login with username "+userName+" "+" and with password"+pwd);
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[3][2];
		data[0][0]="user1";
		
		data[0][1]="pwd1";
		data[1][0]="user2";data[1][1]="pwd2";
		data[2][0]="user3";data[2][1]="pwd3";
		return data;
	}

}
