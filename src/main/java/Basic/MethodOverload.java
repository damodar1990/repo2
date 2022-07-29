package Basic;

public class MethodOverload 
{
	public int add(int a,int b)
	{
		return a+b;
		
	}
	public int add(int a,int b,int c) 
	{
		return a+b+c;
		
	}

	public static void main(String[] args) 
	{
		MethodOverload mt=new MethodOverload();
		System.out.println(mt.add(1, 6));
		System.out.println(mt.add(2, 2, 0));
		
	}

}
