package Stack;

import java.util.Stack;

public class testingStach {

	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<>();
		
		s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        
        System.out.println(s);
        
        Stack<Integer> s1 = new Stack<Integer>();
        reverseStack(s, s1);
        
        s = s1;
        
        System.out.println(s);

	}
	
	public static void reverseStack(Stack<Integer> s, Stack<Integer> s1)
	{
	    if (s.isEmpty())
	        return;
	    
	    int temp = s.pop();
	    
	    s1.push(temp);
	       
	    reverseStack(s, s1);
	    
	}

}
