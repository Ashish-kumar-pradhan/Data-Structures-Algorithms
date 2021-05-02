package linkedList;

import java.util.Scanner;

public class ReverseLL {
	
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
	
	public static Node<Integer> reverse(Node<Integer> head){
		
		if (head == null || head.next == null) {
			return head;
		}
		
	    Node<Integer> reverseHead = reverse(head.next);
		Node<Integer> temp = reverseHead ;
		while(temp.next != null) {
			temp = temp.next;
		}
		head.next = null ;
		temp.next = head ;
		return reverseHead ;
	}
	

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		print(head);
		Node<Integer> reversehead = reverse(head);
		print(reversehead);

	}

}
