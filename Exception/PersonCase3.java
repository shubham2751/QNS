package Exception;

public class PersonCase3 {

	private String name;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) { // throws Exception{

		try {
			if (age < 0)
				throw new Exception("Age can't be -ve");

			this.age = age;
		} catch (Exception e) {
			System.out.println("in catch");
			System.out.println(e.getMessage());
		}

		System.out.println("Bye set Age");
	}

}
