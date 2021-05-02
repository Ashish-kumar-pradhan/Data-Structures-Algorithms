package linkedList;

import java.util.Scanner;

public class ReverseLLItrette {
	
	

	public static Node<Integer> takeInput(){
		Node <Integer> head = null , tail = null;
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		
		while(data != -1) {
			Node<Integer> newNode = new Node<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			} else {
				
				tail.next = newNode;
				tail = newNode;
			}
			data = sc.nextInt();
		}
		return head;
	}
	
	public static void print(Node<Integer> head) {

		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	

	public static Node<Integer> reverse1(Node<Integer> head){
	
		Node<Integer> crnt = head ;
		Node<Integer> prev = null ;
		Node<Integer> temp ;
		
		while(crnt != null){
			temp = crnt.next;
			crnt.next = prev;
			prev = crnt;
			crnt = temp;
		}
		return prev;
	}

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		head = reverse1(head);
		print(head);
		
	}

}
