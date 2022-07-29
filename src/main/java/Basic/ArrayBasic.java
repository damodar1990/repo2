package Basic;

public class ArrayBasic {

	public static void main(String[] args) 
	{
		int a[]=new int[5];
		a[0]=3;
		a[1]=5;
		a[2]=6;
		a[3]=10;
		a[4]=21;
		
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		
		int b[]= {1,3,4,5,6,7,11};
		
		for(int i=0;i<=b.length;i++)
		{
			System.out.println(b[i]);
		}
		
	
	}

}
