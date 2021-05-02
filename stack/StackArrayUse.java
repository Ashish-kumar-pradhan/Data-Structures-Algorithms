package stack;

public class StackArrayUse {

	public static void main(String[] args) throws StackFullException {
		// TODO Auto-generated method stub
		
		StackUsingArray stack = new StackUsingArray();
		
		for (int i = 1 ; i <= 5 ; i++ ) {
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			try {
				System.out.println(stack.pop());
			} catch (StackEmptyException e) {
				// Never Reach here.
			}
		}

	}

}
