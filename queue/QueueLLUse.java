package queue;

public class QueueLLUse {

	public static void main(String[] args) {
		
		QueueUsingLL queue = new QueueUsingLL();
		for(int i = 1 ; i <= 5 ; i++) {
			queue.enqueue(i);
		}
		
		System.out.println(queue.size());
		
		while(!queue.isEmpty()) {
			try {
				System.out.println(queue.dequeue());
			} catch (QueueEmptyException e) {

				e.printStackTrace();
			}
			
			System.out.println(queue.size());

	}

	}
}
