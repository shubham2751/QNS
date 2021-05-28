package Exception;

public class PersonCase1 {

	private String name;
	private int age;
	

	public int getAge() {
		return age;
	}
	public void setAge(int age) throws Exception{
		
		if (age < 0)
			throw new Exception ("Age can't be -ve");
		
		this.age = age;
	}
	
	
}
