package Basic;

public class ReverseDemo {

	public static void main(String[] args) 
	{
		String s1="damodar";
		String t="";
		for(int i=s1.length()-1;i>=0;i--)
		{
			t=t+s1.charAt(i);
		}
	
System.out.println(t);

}
}


