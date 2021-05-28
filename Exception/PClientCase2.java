package Exception;

public class PClientCase2 {

//	public static void main(String[] args) { // throws Exception{
//		
//		System.out.println("Hello");
//		
//		try
//		{
//			PersonCase1 p = new PersonCase1();
//		
//			p.setAge(-20);
//		
//			System.out.println(p.getAge());
//		}
//		catch(Exception e)
//		{
//			System.out.println("catch in");
//		}
//		
//		System.out.println("bye");
//	}

//	public static void main(String[] args) { // throws Exception{
//
//		System.out.println("Hello");
//
//		PersonCase1 p = new PersonCase1();
//		try {
//			p.setAge(-20);
//		} 
//		catch (Exception e) {
//			System.out.println("catch in");
//		}
//		System.out.println(p.getAge());
//		System.out.println("bye");
//	}
	
	public static void main(String[] args) { // throws Exception{

		System.out.println("Hello");

		
		try 
		{
			PersonCase2 p = new PersonCase2();
			p.setAge(20);
//			p.setAge(-20);
			System.out.println(p.getAge());
			return; 
		} 
		catch (Exception e) 
		{
//			System.out.println("catch in");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("in finally");
		}
		
		
		System.out.println("bye"); // this is not printed in return
	}

}
