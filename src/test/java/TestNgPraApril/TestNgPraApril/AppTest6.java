package TestNgPraApril.TestNgPraApril;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class AppTest6 
{
	@Parameters({"user","pwd","Name","Address"})
	@Test()
	public void login(String userName,String pwd,String UName,String UAddress)
	{
		System.out.println("collected parameter- "+userName+ " " +pwd+ " " +UName+ " " +UAddress);
		}
	
	
	@Parameters({"user1","pwd1","Name1","Address1"})
	@Test()
	public void login1(String userName,String pwd,String UName,String UAddress)
	{
		System.out.println("collected parameter- "+userName+ " " +pwd+ " " +UName+ " " +UAddress);
		}
	
	
			
}
