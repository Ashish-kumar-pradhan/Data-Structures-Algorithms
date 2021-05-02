package stack;

public class StackLLUse {

	public static void main(String[] args) throws StackEmptyException {
		// TODO Auto-generated method stub
		
		StackUsingLL stack = new StackUsingLL();
		
		for(int i = 1 ; i <= 10 ; i++) {
			stack.push(10*i);
		
		} 
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		
		System.out.println(stack.top());
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());	
		}
			
		

	}

}
