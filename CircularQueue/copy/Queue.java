// Queue Using Array
package CircularQueue.copy;

public class Queue {
	
	int data[];
	int front;
	int size;
	
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
	
	public void enqueue(int item)
	{
		int idx = front + size;
		data[idx] = item;
		size++;
	}
	
	public int dequeue()
	{
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
		for (int i = front; i < size; i++)
			System.out.print(data[i] + " ");
		System.out.println();
	}
	
}
