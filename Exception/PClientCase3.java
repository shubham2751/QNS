package Exception;

public class PClientCase3 {

	public static void main(String[] args) throws Exception{
		
		System.out.println("Hello");
		
		PersonCase3 p = new PersonCase3();
		
		p.setAge(-20);
		
		System.out.println(p.getAge());
		
		System.out.println("Bye");
		
	}

}
