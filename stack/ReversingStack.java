package stack;

public class ReversingStack {
	
	public static void reverse() {
	
	}

	public static void main(String[] args) {
		
		StackUsingLL stack1 = new StackUsingLL();
		StackUsingLL stack2 = new StackUsingLL();
		
		for(int i = 1 ; i <= 5 ; i++ ) {
			stack1.push(i);
		}
		
		stack1.top();
		
		while(!stack1.isEmpty()) {
			try {
				stack2.push(stack1.pop());
			} catch (StackEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

		stack2.top();
		
//		while(!stack2.isEmpty()) {
//			try {
//				System.out.println(stack2.pop());
//			} catch (StackEmptyException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

	}

}
