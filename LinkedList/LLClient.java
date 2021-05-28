package LinkedList;

public class LLClient {

	public static void main(String[] args) throws Exception {
		
		LinkedList ll = new LinkedList(); // head = null ; head is a Variable
		
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		
		ll.display();
		
		ll.addFirst(60);
		
		ll.display();

	}

}
