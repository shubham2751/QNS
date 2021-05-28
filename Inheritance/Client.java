package Inheritance;

public class Client {

	public static void main(String[] args) {
		
		// Case 1 :
		
		P obj1 = new P();
		
		System.out.println(obj1.d); // 10
		System.out.println(obj1.d1); // 100
		
		obj1.fun(); // in P's Fun
		obj1.fun1(); // in P's Fun1
		
		// Case 2 :
		
		P obj2 = new C();
		
		System.out.println(obj2.d); // 10
		System.out.println(obj2.d1); // 100
		
		System.out.println( ( (C)obj2 ).d2); // Type Cast // 200
//		System.out.println(obj2.d); // 10
		System.out.println( ( (C)obj2 ).d); // 20
		
		obj2.fun(); // in C's Fun
		((P)obj2).fun(); // in C's Fun
		
		obj2.fun1(); // in P's Fun1
		
		( (C)obj2 ).fun2(); // in C's Fun2
		
		// Case 3 :
		
		// C obj3 = new P(); 
		// this is not allowed because instance created of P(Parent)
		// d = 10 d1 = 100
		
		
		// Case 4 :
		
		C obj4 = new C();
		
		System.out.println(obj4.d); // 20
		System.out.println( ( (P)obj4 ).d); // 10
		
		System.out.println(obj4.d1); // 100
		System.out.println(obj4.d2); // 200
		
		obj4.fun(); // in C's Fun
		obj4.fun1(); // in P's Fun1
		obj4.fun2(); // in C's Fun2
		
		

	}

}
