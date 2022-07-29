package Basic;

public class InterfaceClass implements CentralTraffic,Central2 {

	public static void main(String[] args) 
	{
		
   CentralTraffic ct=new InterfaceClass();
   Central2 c2=new InterfaceClass();
   
   ct.GreenGo();
   ct.FlashYellow();
   ct.RedStop();
   c2.GoMonday();

   
    
   
   
		
	}

	public void GreenGo() {
		System.out.println("green");
		
	}

	public void RedStop() 
	{
	System.out.println("Red Stop");
		
	}

	public void FlashYellow() 
	{

    System.out.println("Flash Yellow");
		
	}

	public void GoMonday() 
	{
	System.out.println("monday go");
		
	}

}
