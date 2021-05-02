package doubleLinkList;

import linkedList.Node;

public class DoubleLLUse {

	public static void main(String[] args) {
		
		Node2<Integer> node1 = new Node2<Integer>(10);
		Node2<Integer> node2 = new Node2<Integer>(20);
		Node2<Integer> node3 = new Node2<Integer>(30);
		Node2<Integer> node4 = new Node2<Integer>(40);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node2.prev = node1;
		node3.prev = node2;
		node4.prev = node3;
		
		Node2<Integer> tail = node4;
		
		while(tail != null) {
			System.out.print(tail.data + " ");
			tail = tail.prev;
		}
	}

}
