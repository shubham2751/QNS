package Exception;

public class PClientCase1 {

	public static void main(String[] args) throws Exception{
		
		System.out.println("Hello");
		
		PersonCase1 p = new PersonCase1();
		
		p.setAge(-20);
		
		System.out.println(p.getAge());
		
	}

}
