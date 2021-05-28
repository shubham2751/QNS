package Stack;

public class SClient {

	public static void main(String[] args) throws Exception 
	{
		
		Stack s = new Stack(3);
		
		s.push(10);
		s.push(20);
		s.push(30);
//		s.push(40);
		
		s.display();
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
//		System.out.println(s.pop());
		
		s.display();

	}

}
