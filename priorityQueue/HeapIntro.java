package priorityQueue;

import java.util.ArrayList;

public class HeapIntro {
	
	private ArrayList<Integer> heap;
	
	public HeapIntro() {
		heap = new ArrayList<>();
	}
	boolean isEmpty() {
		return heap.size() == 0 ;
	}
	
	int size() {
		return heap.size();
	}
	
	int getMin() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}
	
	void insert(int element) {
		heap.add(element);
		int childIndex = heap.size()-1;
		int parentIndex = (childIndex - 1) / 2 ;
		
		while(childIndex > 0) {
			if(heap.get(childIndex) < heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2 ;
			}else {
				return;
			}
		}
		
	}
	
	int removemin() throws PriorityQueueException {
		
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		
		int minValue = heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int parentIndex = 0;
		int leftChildIndex =  1;
		int rightChildIndex = 2;
		
		while(leftChildIndex < heap.size() - 1 ) {
			
			if(heap.get(leftChildIndex) < heap.get(parentIndex)) {
				int temp1 = heap.get(parentIndex);
				heap.set(parentIndex, heap.get(leftChildIndex));
				heap.set(leftChildIndex, temp1);
				parentIndex = leftChildIndex;
				leftChildIndex = 2*parentIndex + 1;
				rightChildIndex = 2*parentIndex + 2;
				
			}
			else if (rightChildIndex < heap.size() &&   heap.get(rightChildIndex) < heap.get(parentIndex)) {
				int temp2 = heap.get(parentIndex);
				heap.set(parentIndex, heap.get(rightChildIndex));
				heap.set(rightChildIndex, temp2);
				parentIndex = rightChildIndex;
				leftChildIndex = 2*parentIndex + 1;
				rightChildIndex = 2*parentIndex + 2;
			}
			
			else {
				break;
			}
		}
		
		return minValue;
		
	}
	

    int removeMin() throws PriorityQueueException {
		
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		
		int minValue = heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int index = 0 ;
		int minIndex = index ;
		int leftChildIndex = 1;
		int rightChildIndex = 2;
		
		while(leftChildIndex < heap.size()) {
			if(heap.get(leftChildIndex) < heap.get(minIndex)) {
				minIndex = leftChildIndex;
			}
			if(rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)) {
				minIndex = rightChildIndex;
			}
			
			if(minIndex == index ) {
				break;
			} else {
				int temp = heap.get(index);
				heap.set(index, heap.get(minIndex));
				heap.set(minIndex, temp);
				index = minIndex;
				leftChildIndex = 2*index + 1;
				rightChildIndex = 2*index + 2;
			}
		}
		
		return minValue;
		
    }


}
