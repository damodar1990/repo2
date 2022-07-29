package Basic;

public class MethodOverride
{
	public void eat()
	{
		System.out.println("eating");
	}
	
	public class child extends MethodOverride
	{
		public void eat() 
		{
			System.out.println("eating");
		}
	}

	public static void main(String[] args) 
	{
		MethodOverride m=new MethodOverride ();
		
		

	}

}
