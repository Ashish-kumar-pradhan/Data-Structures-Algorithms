package doubleLinkList;

public class CircularDoubleLL {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node2<Integer> node1 = new Node2<Integer>(10);
		Node2<Integer> node2 = new Node2<Integer>(20);
		Node2<Integer> node3 = new Node2<Integer>(30);
		Node2<Integer> node4 = new Node2<Integer>(40);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node1;
		node2.prev = node1;
		node3.prev = node2;
		node4.prev = node3;
		node1.prev = node4;
		
		Node2<Integer> head = node1 ;
		Node2<Integer> temp = head ;
		System.out.print(temp.data + " ");
		while (temp != head.prev) {
			temp = temp.next;
			System.out.print(temp.data + " ");
		}


	}

}
