package stack;

public class StackUsingArray {

	private int data[];
	private int top;
	
	public StackUsingArray() {
		data = new int[10];
		top = -1;
	}
	
	public StackUsingArray(int capacity) {
		data = new int[capacity];
		top = -1;
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public int size() {
		return top + 1;
	}
	
	public int top() throws StackEmptyException {
		if(size() == 0 ) {
			// stack Empty Exception.
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		
		return data[top];
	}
	
	public void push(int elem) throws StackFullException {
		if(size() == data.length) {
			// stack Full Exception.
			StackFullException e = new StackFullException();
			throw e;
		}
		
		top++;
		data[top] = elem;
	}
	
	public int pop() throws StackEmptyException {
		
		if(size() == 0 ) {
			// stack Empty Exception.
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		
		int temp = data[top];
		top--;
		return temp;
	}
	

}
