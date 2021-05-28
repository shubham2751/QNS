// Queue Using Array
package Queue;

public class CircularQueue {
	
	private int data[];
	private int front;
	private int size;
	
	public CircularQueue()
	{
		data = new int[5];
		front = 0;
		size = 0;
	}
	
	public CircularQueue(int cap)
	{
		data = new int[cap];
		front = 0;
		size = 0;
	}
	
	public void enqueue(int item) throws Exception
	{
		if (isFull())
			throw new Exception("Queue is Full.");
		
		int idx = (front + size) % data.length;
		data[idx] = item;
		size++;
	}
	
	public int dequeue() throws Exception
	{
		if (isEmpty())
			throw new Exception("Queue is Empty.");
		
		int temp = data[front];
		data[front] = 0;
		
		front = (front + 1) % data.length;
		size--;
		
		return temp;
	}
	
	public int getFront() throws Exception
	{
		if (isEmpty())
			throw new Exception("Queue is Empty Not a Element on top");
		
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
		{
			int idx = (front + i) % data.length;
			System.out.print(data[idx] + " ");	
		}
			
		System.out.println();
	}
	
}
