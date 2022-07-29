package Basic;

public class child extends Parent
{
	
	public void color()
	{
		System.out.println(color);
	}

	public static void main(String[] args) 
	{
		child c=new child();
		c.color1();
		c.color();

	}

}
