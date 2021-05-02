package linkedList;

import java.util.Scanner;

public class DeletingNode {
	
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
	
	public static void delete(Node<Integer> head , int pos) {
		int i = 0;
		Node<Integer> temp = head;
		while(i < pos-1) {
			temp = temp.next;
			i++;
		}
		temp.next = temp.next.next; 
	}

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		delete(head , 0);
		print(head);
	
	}

}
