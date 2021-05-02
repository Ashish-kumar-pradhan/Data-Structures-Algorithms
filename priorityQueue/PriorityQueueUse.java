package priorityQueue;

public class PriorityQueueUse {

	public static void main(String[] args) throws PriorityQueueException {
		// TODO Auto-generated method stub
		
		HeapIntro pq = new HeapIntro();
		int arr[] = {5 , 1 , 9 , 2 , 0};
		for(int i = 0 ; i < arr.length ; i++) {
			pq.insert(arr[i]);
		}
		
		while(! pq.isEmpty()) {
			System.out.print(pq.removeMin() + " ");
		}
		System.out.println();

	}

}

