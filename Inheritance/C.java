package Inheritance;

public class C extends P{
	
	int d = 20;
	int d2 = 200;
	
	@Override
	public void fun()
	{
		System.out.println("in C's Fun");
//		super.fun();
	}
	
	public void fun2()
	{
		System.out.println("in C's Fun2");
	}
	

}
