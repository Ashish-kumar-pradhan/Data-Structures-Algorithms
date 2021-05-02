package linkedList;

import java.util.Scanner;

public class MidPointInLL {
	
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
	
	public static void mid(Node<Integer> head) {
		
		Node<Integer> fast = head;
		Node<Integer> slow = head;
		Node<Integer> temp = head;
		
		int i = 0;
		while(temp != null ) {
			temp = temp.next;
			i++;
		}
		
		if (i%2 == 0) {
			
			while(fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
		} else {
			
			while(fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			
		}
		
		
		System.out.println(slow.data);
	}

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		mid(head);
		
	}

}
