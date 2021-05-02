package queue;

public class QueueUsingArray {
	
	private int data[] ;
	private int front ;
	private int rear ;
	private int size ;
	
	public QueueUsingArray() {
		data = new int[10];
		front =  -1 ;
		rear = -1 ;
		size = 0 ;
	}
	
	public QueueUsingArray(int capacity) {
		data = new int[capacity];
		front =  -1 ;
		rear = -1 ;
		size = 0 ;
	}
	
	int size() {
		return size;
	}
	
	boolean isEmpty() {
		return size == 0 ;
	}
	
	int front() throws QueueEmptyException {
		if(size == 0) {
			throw new QueueEmptyException();
		}
		return data[front];
	}
	
	void enqueue(int elem) throws QueueFullException {
		
		if (size == data.length) {
			throw new QueueFullException(); 
		}
		
		if(size == 0) {
			front = 0 ;
		}
		rear++;
		size++;
		if(rear == data.length) {
			rear = 0;
		}
		data[rear] = elem;
	}
	
	int dequeue() throws QueueEmptyException {
		

		if (size == data.length) {
			throw new QueueEmptyException(); 
		}
		
		int temp = data[front];
		front++;
		if (front == data.length) {
			front++;
		}
		size--;
		if(size == 0) {
			front = -1;
			rear = -1;
		}
		return temp ;
	}
	
}
