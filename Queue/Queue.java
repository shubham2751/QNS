// Queue Using Array
package Queue;

public class Queue {
	
	private int data[];
	private int front;
	private int size;
	
	public Queue()
	{
		data = new int[5];
		front = 0;
		size = 0;
	}
	
	public Queue(int cap)
	{
		data = new int[cap];
		front = 0;
		size = 0;
	}
	
	public void enqueue(int item) throws Exception
	{
		if (isFull())
			throw new Exception("Queue is Full.");
		
		
		int idx = front + size;
		data[idx] = item;
		size++;
	}
	
	public int dequeue() throws Exception
	{
		if (isEmpty())
			throw new Exception("Queue is Empty.");
		
		int temp = data[front];
		data[front] = 0;
		
		front++;
		size--;
		
		return temp;
	}
	
	public int getFront()
	{
		int temp = data[front];
		
		return temp;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	public boolean isFull()
	{
		return size() == data.length;
	}
	
	public void display()
	{
		for (int i = 0; i < size; i++)
			System.out.print(data[front+i] + " ");
		System.out.println();
	}
	
}
