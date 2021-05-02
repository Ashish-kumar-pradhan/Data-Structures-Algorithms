package linkedList;

public class WhilePrint {

	public static void main(String[] args) {
		
		Node<Integer> node1 = new Node<Integer>(10);
		Node<Integer> node2 = new Node<Integer>(20);
		Node<Integer> node3 = new Node<Integer>(30);
		Node<Integer> node4 = new Node<Integer>(40);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		Node<Integer> head = node1;
		
		while(head != null ) {
			System.out.print(head.data + " ");
			head = head.next;
		}

	}

}
